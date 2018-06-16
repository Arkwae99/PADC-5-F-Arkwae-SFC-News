package com.padcmyanmar.sfc.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "NewsInImage", foreignKeys = {
        @ForeignKey(
                entity = NewsVO.class,
                parentColumns = "newsId",
                childColumns = "newsId",
                onDelete = ForeignKey.CASCADE
        )})
public class NewsInImageVO {

    @PrimaryKey(autoGenerate = true)
    private int newsInImageId;

    private String imageUrl;

    private String newsId;

    public int getNewsInImageId() {
        return newsInImageId;
    }

    public void setNewsInImageId(int newsInImageId) {
        this.newsInImageId = newsInImageId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
}
