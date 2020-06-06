package com.swufe.myfinaltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
final String TAG = "LoginActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void btnRegister(View btn){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        Log.i(TAG,"注册新用户");
    }

}