/*
 * Copyright 2017, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.padcmyanmar.sfc.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;
import com.padcmyanmar.sfc.data.vo.CommentActionVO;
import com.padcmyanmar.sfc.data.vo.FavoriteActionVO;
import com.padcmyanmar.sfc.data.vo.NewsInImageVO;
import com.padcmyanmar.sfc.data.vo.NewsVO;
import com.padcmyanmar.sfc.data.vo.PublicationVO;
import com.padcmyanmar.sfc.data.vo.SentToVO;

@Database(entities = {
                       NewsVO.class, NewsInImageVO.class, PublicationVO.class, ActedUserVO.class,
                       CommentActionVO.class, FavoriteActionVO.class, SentToVO.class
                     }, version = 12, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "PADC-MMNEWS-DB.DB";

    private static AppDatabase INSTANCE;

    public abstract NewsDao newsDao();

    public abstract NewsInImageDao newsInImageDao();

    public abstract PublicationDao publicationDao();

    public abstract ActedUserDao actedUserDao();

    public abstract CommentActionDao commentActionDao();

    public abstract FavoriteActionDao favoriteActionDao();

    public abstract SendToDao sendToDao();

    public static AppDatabase getNewsDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                            .allowMainThreadQueries() //Remove this after testing. Access to DB should always be from background thread.
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}