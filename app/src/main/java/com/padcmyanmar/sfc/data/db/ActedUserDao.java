package com.padcmyanmar.sfc.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.ActedUserVO;

import java.util.List;

@Dao
public interface ActedUserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertActedUser(ActedUserVO actedUser);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertActedUsers(List<ActedUserVO> actedUsers);

    @Query("SELECT * FROM acteduser")
    LiveData<List<ActedUserVO>> getAllActedUsers();

    @Query("DELETE FROM acteduser")
    void deleteAll();

}
