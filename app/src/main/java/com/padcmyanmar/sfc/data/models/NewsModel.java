package com.padcmyanmar.sfc.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.padcmyanmar.sfc.SFCNewsApp;
import com.padcmyanmar.sfc.data.db.AppDatabase;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;
import com.padcmyanmar.sfc.data.vo.FavoriteActionVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;
import com.padcmyanmar.sfc.events.RestApiEvents;
import com.padcmyanmar.sfc.network.MMNewsDataAgent;
import com.padcmyanmar.sfc.network.MMNewsDataAgentImpl;
import com.padcmyanmar.sfc.utils.AppConstants;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aung on 12/3/17.
 */

public class NewsModel extends ViewModel {

    private static NewsModel objInstance;

    private AppDatabase mAppDatabase;

    private LiveData<Map<String, NewsVO>> mAttractionMapLiveData;

    private int mmNewsPageIndex = 1;

    public NewsModel() {
        EventBus.getDefault().register(this);

        startLoadingMMNews();
    }

    public static NewsModel getInstance() {
        if(objInstance == null) {
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void startLoadingMMNews() {
        MMNewsDataAgentImpl.getInstance().loadMMNews(AppConstants.ACCESS_TOKEN, mmNewsPageIndex);
    }


    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getAttractionsDatabase(context);
    }

    public LiveData<List<NewsVO>> getAttractions() {
        return mAppDatabase.attractionsDao().getNews();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        AppDatabase.destroyInstance();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onAttractionsLoadedEvent(RestApiEvents.NewsDataLoadedEvent event) {
        mAppDatabase.attractionsDao().deleteAll();
        long[] insertedIds = mAppDatabase.attractionsDao()
                .insertNews(event.getLoadNews().toArray(new NewsVO[0]));

        Log.d(SFCNewsApp.LOG_TAG, "Total inserted count : " + insertedIds.length);
    }
}
