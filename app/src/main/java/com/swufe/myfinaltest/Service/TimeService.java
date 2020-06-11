package com.swufe.myfinaltest.Service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TimeService {
    private DatabaseHelper dbHelper;
    private String TBNAME2;
    public TimeService(Context context){
        dbHelper=new DatabaseHelper(context);
        TBNAME2 = dbHelper.TB_NAME2;
    }
    public void add(Time time){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
//        values.put("Id",time.getId());
        values.put("username",time.getUsername());
        values.put("time",time.getTime());
        values.put("thing",time.getThing());
        db.insert(TBNAME2,null,values);
        db.close();
    }
    public List<Time> listAll(){
        List<Time> TimeItemList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TBNAME2,null,null,null,null,null,null);
        if (cursor != null){
            TimeItemList = new ArrayList<Time>();
            while (cursor.moveToNext()){
                Time item = new Time();
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setTime(cursor.getString(cursor.getColumnIndex("time")));
                item.setThing(cursor.getString(cursor.getColumnIndex("thing")));
                TimeItemList.add(item);
            }
            cursor.close();
        }
        db.close();
        return TimeItemList;
    }
}
