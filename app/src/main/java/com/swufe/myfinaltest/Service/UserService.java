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
        String sql=  " select * from "+ TBNAME1 + " where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean register(User user){
        SQLiteDatabase sdb=dbHelper.getWritableDatabase();
        String sql=  "insert into "+TBNAME1+" values(?,?,?,?,?)";
        Object obj[]={null,user.getUsername(),user.getPassword(),user.getQuestion(),user.getAnswer()};
        sdb.execSQL(sql, obj);
        return true;
    }
    public boolean isNewRegister(String username){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql= " select * from "+ TBNAME1 + "  where username=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username});
        if(cursor.moveToFirst() == true){
            cursor.close();
            return false;
        }
        return true;
    }
    public String getQuestion(String username){
        String question = null;
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        Cursor cursor =  sdb.query(TBNAME1,null, null ,null,null,null,null);
        if (cursor != null){
            while (cursor.moveToNext()){
                if (cursor.getString(cursor.getColumnIndex("username")).equals(username)){
                    question = cursor.getString(cursor.getColumnIndex("question"));
                }
            }
            cursor.close();
        }
        sdb.close();
        return  question;
    }
    public String getPassword(String username){
        String password = null;
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        Cursor cursor =  sdb.query(TBNAME1,null, null ,null,null,null,null);
        if (cursor != null){
            while (cursor.moveToNext()){
                if (cursor.getString(cursor.getColumnIndex("username")).equals(username)){
                    password = cursor.getString(cursor.getColumnIndex("password"));
                }
            }
            cursor.close();
        }
        sdb.close();
        return  password;
    }
    public String getAnswer(String username){
        String answer = null;
        SQLiteDatabase sdb = dbHelper.getReadableDatabase();
        Cursor cursor =  sdb.query(TBNAME1,null, null ,null,null,null,null);
        if (cursor != null){
            while (cursor.moveToNext()){
                if (cursor.getString(cursor.getColumnIndex("username")).equals(username)){
                    answer = cursor.getString(cursor.getColumnIndex("answer"));
                }
            }
            cursor.close();
        }
        sdb.close();
        return  answer;
    }
    public boolean isAnswerRight(String username,String answer){
        String realAns = getAnswer(username);
        return realAns.equals(answer);
    }

}
