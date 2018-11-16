package com.example.tneagu.todaynews.repositories;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.tneagu.todaynews.database.AppDatabase;
import com.example.tneagu.todaynews.database.FavoriteDao;
import com.example.tneagu.todaynews.models.FavoriteItem;
import com.example.tneagu.todaynews.models.News;

import java.util.List;

public class NewsRepository {

    private FavoriteDao favoriteDao;
    private LiveData<List<FavoriteItem>> favorites;

    public NewsRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        favoriteDao = db.favoritesDao();
        favorites = favoriteDao.getAllFavoriteItems();
    }


    public void insertFavorite(News item){
        FavoriteItem favorite = new FavoriteItem(item);
        new insertAsyncTask(favoriteDao).execute(favorite);
    }

    public void deleteFavorite(News item){
        FavoriteItem favorite = new FavoriteItem(item);
        new deleteAsyncTask(favoriteDao).execute(favorite);
    }

    private static class insertAsyncTask extends AsyncTask<FavoriteItem, Void, Void> {

        private FavoriteDao mAsyncTaskDao;

        insertAsyncTask(FavoriteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FavoriteItem... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<FavoriteItem, Void, Void> {

        private FavoriteDao mAsyncTaskDao;

        deleteAsyncTask(FavoriteDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final FavoriteItem... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}
