package com.example.luis.testcontetprovider.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.luis.testcontetprovider.Constants.Data.DataConstant;


/**
 * Created by luis on 13/12/17.
 */

public class NewsHelper extends SQLiteOpenHelper {

    public static String TABLE_NAME = "news";
    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+TABLE_NAME ;
    public static String ID = "_id";
    public static String TITLE = "title";
    public static String DESCRIPTION = "description";
    public static String IMAGE = "image";
    public static String SQL_CREATE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +" ( "+ ID +" INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 , "+ TITLE +" TEXT , "+ DESCRIPTION +" TEXT , "+ IMAGE +" TEXT)";


    public NewsHelper(Context context) {
        super(context, DataConstant.DATA_NAME, null, DataConstant.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
