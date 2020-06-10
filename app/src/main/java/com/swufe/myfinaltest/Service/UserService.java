package com.swufe.myfinaltest.Service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserService {
    private DatabaseHelper dbHelper;
    private String TBNAME1;
    public UserService(Context context){
        dbHelper=new DatabaseHelper(context);
        TBNAME1 = dbHelper.TB_NAME1;
    }

    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql=TBNAME1 + "select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql=TBNAME1 + "insert into user(username,password) values(?,?)";
        Object obj[]={user.getUsername(),user.getPassword()};
        sdb.execSQL(sql, obj);
        return true;
    }
    public boolean isNewRegister(String username){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql=TBNAME1 + "select * from user where username=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username});
        if(cursor.moveToFirst() == true){
            cursor.close();
            return false;
        }
        return true;
    }

}
