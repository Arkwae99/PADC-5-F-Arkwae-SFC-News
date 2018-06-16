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
@Entity(tableName = "FavoriteAction", foreignKeys = {
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
public class FavoriteActionVO {

    @PrimaryKey
    @SerializedName("favorite-id")
    @NonNull
    private String favoriteId;

    @SerializedName("favorite-date")
    private String favoriteDate;

    @Ignore
    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    private String newsId;

    private String actedUserId;

    public String getFavoriteId() {
        return favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public void setFavoriteId(String favoriteId) {
        this.favoriteId = favoriteId;
    }

    public void setFavoriteDate(String favoriteDate) {
        this.favoriteDate = favoriteDate;
    }

    public void setActedUser(ActedUserVO actedUser) {
        this.actedUser = actedUser;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getActedUserId() {
        return actedUserId;
    }

    public void setActedUserId(String actedUserId) {
        this.actedUserId = actedUserId;
    }
}
