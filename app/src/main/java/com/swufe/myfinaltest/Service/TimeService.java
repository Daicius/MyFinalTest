package com.swufe.myfinaltest.Service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TimeService {
    private DatabaseHelper dbHelper;
    private String TBNAME2;
    public TimeService(Context context){
        dbHelper=new DatabaseHelper(context);
        TBNAME2 = dbHelper.TB_NAME2;
    }
    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME2,null,null);
        db.close();
    }
}
