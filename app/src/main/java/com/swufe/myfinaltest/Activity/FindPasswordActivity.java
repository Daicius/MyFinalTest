package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.UserService;

public class FindPasswordActivity extends AppCompatActivity {
    String username;
    EditText editText;
    final String TAG = "FindPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
    }
    public void btn_find(View view){
        editText = findViewById(R.id.et_find);
        username = editText.getText().toString();
        Log.i(TAG,"username = "+username);
        UserService service = new UserService(this);
        boolean flag = service.isNewRegister(username);
        if (flag){
            Toast.makeText(FindPasswordActivity.this, "没有此用户", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"没有此用户,返回登陆界面");
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(this, FindPasswordActivity2.class);
            Log.i(TAG, "获得用户名，前往问题");
            intent.putExtra("username",username);
            startActivity(intent);
        }

    }
}