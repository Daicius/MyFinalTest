package com.swufe.myfinaltest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
EditText code;
EditText codeConfirm;
EditText userName;
final String TAG = "RegisterActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
    public void btnFinish(View btn){
        userName = findViewById(R.id.userName);
        code = findViewById(R.id.code1);
        codeConfirm = findViewById(R.id.code2);
        String username = userName.getText().toString();
        if (username.length() == 0){
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_SHORT).show();
            userName.setText(null);
            code.setText(null);
            codeConfirm.setText(null);
        }else {
            String code1 = code.getText().toString();
            Log.i(TAG,"code1="+code1);
            String code2 = codeConfirm.getText().toString();
            Log.i(TAG,"code2="+code2);
            if(code1.length()<6){
                Toast.makeText(this,"请输入六位密码",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"注册失败");
                code.setText(null);
                codeConfirm.setText(null);
            }else if (!code1.equals(code2)){
                Toast.makeText(this,"前后密码不一致",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"注册失败");
                code.setText(null);
                codeConfirm.setText(null);
            }else {
                Log.i(TAG,"注册成功");
                Intent intent = new Intent(this,LoginActivity.class);
                startActivity(intent);
            }
        }

    }

}