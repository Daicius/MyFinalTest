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
        db.execSQL("CREATE TABLE " + TB_NAME1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,username varchar(20),password varchar(20))");
        db.execSQL("CREATE TABLE " + TB_NAME2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,username String,time String,thing String)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
