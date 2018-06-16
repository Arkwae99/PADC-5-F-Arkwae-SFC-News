package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by aung on 12/3/17.
 */
@Entity(tableName = "CommentAction", foreignKeys = {
        @ForeignKey(
                entity = NewsVO.class,
                parentColumns = "newsId",
                childColumns = "newsId",
                onDelete = ForeignKey.CASCADE
        ),
        @ForeignKey(
                entity = ActedUserVO.class,
                parentColumns = "userId",
                childColumns = "actedUserId",
                onDelete = ForeignKey.CASCADE
        )})
public class CommentActionVO {

    @PrimaryKey
    @SerializedName("comment-id")
    @NonNull
    private String commentId;

    @SerializedName("comment")
    private String comment;

    @SerializedName("comment-date")
    private String commentDate;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String newsId;

    private String actedUserId;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setActedUserId(String actedUserId) {
        this.actedUserId = actedUserId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getNewsId() {
        return newsId;
    }

    public String getActedUserId() {
        return actedUserId;
    }
}
