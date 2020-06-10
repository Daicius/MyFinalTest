package com.swufe.myfinaltest.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    static String name="user.db";
    static String TB_NAME1 = "TB_USER";
    static String TB_NAME2 = "TB_TIME";
    static int dbVersion=1;

    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    public void onCreate(SQLiteDatabase db) {
        String sql="create table " + TB_NAME1 + "user(id integer primary key autoincrement,username varchar(20),password varchar(20))";
        String sql1="create table " + TB_NAME2 + "user(username varchar(20) primary key autoincrement,time String,thing String)";
        db.execSQL(sql);
        db.execSQL(sql1);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
