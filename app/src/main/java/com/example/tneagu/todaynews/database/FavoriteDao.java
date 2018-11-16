package com.example.tneagu.todaynews.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.tneagu.todaynews.models.FavoriteItem;

import java.util.List;

@Dao
public interface FavoriteDao {

    @Insert
    void insert(FavoriteItem item);
    @Delete
    void delete(FavoriteItem item);

    @Query("SELECT * from favorites_table")
    LiveData<List<FavoriteItem>> getAllFavoriteItems();
}
