package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

/**
 * Created by aung on 12/3/17.
 */
@Entity(tableName = "CommentAction",
        foreignKeys = @ForeignKey(entity = ActedUserVO.class,
                                    parentColumns = "actedUserId",
                                    childColumns = "userId"))
public class CommentActionVO {

    @NotNull
    @PrimaryKey
    @ColumnInfo(name = "commentActionId")
    @SerializedName("comment-id")
    private String commentId;

    @SerializedName("comment")
    private String comment;

    @SerializedName("comment-date")
    private String commentDate;

    @ColumnInfo(name = "userId")
    private String userId;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

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

    public String getUserId() {
        return userId;
    }

    public void setCommentId(@NonNull String commentId) {
        this.commentId = commentId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }
}
