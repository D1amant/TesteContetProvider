package com.example.luis.testcontetprovider.Application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.luis.testcontetprovider.DAO.NewsHelper;

/**
 * Created by luis on 13/12/17.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NewsHelper newsHelper = new NewsHelper(this);
        newsHelper.onCreate(newsHelper.getWritableDatabase());

    }
}
