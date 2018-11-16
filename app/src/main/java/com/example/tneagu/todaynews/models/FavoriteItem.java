package com.example.tneagu.todaynews.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.tneagu.todaynews.models.News;

@Entity(tableName = "favorites_table")
public class FavoriteItem {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String url;
    private String publishedAt;

    public FavoriteItem(News news) {
        this.title = news.getTitle();
        this.description = news.getDescription();
        this.url = news.getUrl();
        this.publishedAt = news.getPublishedAt();
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
