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

public class LoginActivity extends AppCompatActivity {
final String TAG = "LoginActivity";
EditText username;
EditText password,question,answer;
String userName;
String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);

        Intent intent = getIntent();
        userName = intent.getStringExtra("username");
        code = intent.getStringExtra("code");
        username.setText(userName);
        password.setText(code);
    }
    public void btnRegister(View btn){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        Log.i(TAG,"注册新用户");
    }
    public void btnLogin(View btn){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        String name=username.getText().toString();
        String pass=password.getText().toString();
        Log.i("TAG",name+"_"+pass);
        UserService uService = new UserService(LoginActivity.this);
        boolean flag = uService.login(name, pass);

        if(flag){
            Log.i("TAG","登录成功");
            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//            Bundle bundle = new Bundle();
//            bundle.putString("username",userName);
//            Fragment fragment = new FirstFragment();
//            fragment.setArguments(bundle);
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("userName",name);
            startActivity(intent);
        }else{
            Log.i("TAG","登录失败");
            password.setText(null);
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
        }
    }
    public void btn_findPassword(View view){
        Log.i("TAG","找回密码");
        Intent intent = new Intent(this,FindPasswordActivity.class);
        startActivity(intent);
    }

}