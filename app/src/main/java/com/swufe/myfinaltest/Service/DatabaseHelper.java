package com.swufe.myfinaltest.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String name="user.db";
    public static final String TB_NAME1 = "USER";
    public static final String TB_NAME2 = "TIME";
    static int dbVersion=1;

    public DatabaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    public void onCreate(SQLiteDatabase db) {
//        String sql="create table " + TB_NAME1 + "(id integer primary key autoincrement,username varchar(20),password varchar(20))";
//        String sql1="create table " + TB_NAME2 + "(username varchar(20) primary key autoincrement,time String,thing String)";
//        db.execSQL(sql);
//        db.execSQL(sql1);
        db.execSQL("CREATE TABLE " + TB_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,username varchar(20),password varchar(20))");
        db.execSQL("CREATE TABLE " + TB_NAME2 + "(username varchar(20) PRIMARY KEY AUTOINCREMENT,time String,thing String)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
