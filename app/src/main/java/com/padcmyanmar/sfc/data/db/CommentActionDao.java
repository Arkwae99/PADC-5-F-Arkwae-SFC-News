package com.padcmyanmar.sfc.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.padcmyanmar.sfc.data.vo.CommentActionVO;

import java.util.List;

@Dao
public abstract class CommentActionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long insertCommentAction(CommentActionVO commentAction);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long[] insertCommentActions(List<CommentActionVO> commentActions);

    @Query("SELECT * FROM commentaction")
    public abstract LiveData<List<CommentActionVO>> getAllCommentActions();

    @Query("SELECT * FROM CommentAction WHERE commentId =:newsId")
    public abstract List<CommentActionVO> getCommentActionsByNewsId(String newsId);

    @Query("DELETE FROM commentaction")
    public abstract void deleteAll();

    public void insertCommentById(String newsId, String actedUserId, CommentActionVO commentActionVO) {
        commentActionVO.setNewsId(newsId);
        commentActionVO.setActedUserId(actedUserId);
        insertCommentAction(commentActionVO);
    }

}
