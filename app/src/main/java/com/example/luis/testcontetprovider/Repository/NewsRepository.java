package com.example.luis.testcontetprovider.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.luis.testcontetprovider.DAO.NewsHelper;
import com.example.luis.testcontetprovider.DAO.RepositoryInterface;
import com.example.luis.testcontetprovider.Model.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luis on 13/12/17.
 */

public class NewsRepository implements RepositoryInterface {

    private List<News> news;
    private NewsHelper newsHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context appContext;

    public NewsRepository(Context appContext , List<News> news) {
        this.news = news;
        this.appContext = appContext;
        newsHelper = new NewsHelper(appContext);
        sqLiteDatabase = newsHelper.getWritableDatabase();
    }

    public NewsRepository(Context appContext) {
        this.appContext = appContext;
        newsHelper = new NewsHelper(appContext);
        sqLiteDatabase = newsHelper.getWritableDatabase();
    }

    @Override
    public List<Long> insert() {
        List<Long> ids = new ArrayList<>();
        if(news.size() > 0){
            for (int i = 0; i < news.size(); i++) {
                ContentValues values = new ContentValues();
                values.put(NewsHelper.TITLE, news.get(i).getTitle());
                values.put(NewsHelper.DESCRIPTION, news.get(i).getDescription());
                values.put(NewsHelper.IMAGE, news.get(i).getImage());
                ids.add(sqLiteDatabase.insert(NewsHelper.TABLE_NAME , null , values));
            }
        }

        return ids ;
    }

    @Override
    public Boolean update() {
        return null;
    }

    @Override
    public Boolean remove() {
        return null;
    }

    @Override
    public Cursor findAll() {

        Cursor cursor = sqLiteDatabase.query(
                NewsHelper.TABLE_NAME,                     // The table to query
                new String[]{NewsHelper.TITLE , NewsHelper.DESCRIPTION , NewsHelper.IMAGE},                               // The columns to return
                "",                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        return cursor;
    }

    @Override
    public Cursor findByID(Long id) {
        Cursor cursor = sqLiteDatabase.query(
                NewsHelper.TABLE_NAME,                     // The table to query
                new String[]{NewsHelper.TITLE , NewsHelper.DESCRIPTION , NewsHelper.IMAGE},                               // The columns to return
                "",                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        return cursor;
    }
    public List<News> findAllObject() {

        Cursor cursor = this.findAll();
        List<News> newsList = new ArrayList<>();
        while (cursor.moveToNext()){
            News news = new News();
            news.setTitle(cursor.getString(0));
            news.setDescription(cursor.getString(1));
            news.setImage(cursor.getString(2));
            newsList.add(news);
        }
        cursor.close();
        return newsList;
    }




}
