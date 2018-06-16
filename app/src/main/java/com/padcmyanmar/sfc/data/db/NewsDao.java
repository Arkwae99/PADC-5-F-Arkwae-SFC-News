package com.padcmyanmar.sfc.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.NewsVO;

import java.util.List;

@Dao
public abstract class NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertNews(NewsVO news);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertNewsList(NewsVO... newsList);

    @Query("SELECT * FROM news")
    public abstract LiveData<List<NewsVO>> getAllNews();

    @Query("DELETE FROM news")
    public abstract void deleteAll();

    public void insertNewsWithPubId(String publicationId, NewsVO newsVO) {
        newsVO.setPublicationId(publicationId);
        insertNews(newsVO);
    }
}
