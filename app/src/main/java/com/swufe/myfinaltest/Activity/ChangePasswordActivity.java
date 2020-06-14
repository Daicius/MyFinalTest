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

public class ChangePasswordActivity extends AppCompatActivity {
EditText et_used,et_new,et_confirm;
String username,oldpass,newpass,cofpass;
final String TAG = "ChangePasswordActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        et_used = findViewById(R.id.usedPassword);
        et_new = findViewById(R.id.newPassword);
        et_confirm = findViewById(R.id.cofPass);
        Intent intent = getIntent();
        username = intent.getStringExtra("username");
    }
    public void btn_rest(View view){
        oldpass = et_used.getText().toString();
        newpass = et_new.getText().toString();
        cofpass = et_confirm.getText().toString();
        UserService service = new UserService(this);
        boolean flag = service.login(username,oldpass);
        if(flag){
            if (newpass.length()>5){
                if (!newpass.equals(oldpass)){
                    if (newpass.equals(cofpass)){
                        Log.i(TAG,"更改密码");
                        service.resetPass(username,newpass);
                        Toast.makeText(ChangePasswordActivity.this, "修改成功，请重新登录", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this,LoginActivity.class);
                        intent.putExtra("username",username);
                        startActivity(intent);
                    }else {
                        Toast.makeText(ChangePasswordActivity.this, "新密码不同", Toast.LENGTH_SHORT).show();
                        Log.i(TAG,"新密码不同");
                        et_confirm.setText(null);
                    }
                }else {
                    Toast.makeText(ChangePasswordActivity.this, "与原密码相同", Toast.LENGTH_SHORT).show();
                    Log.i(TAG,"与原密码相同");
                    et_confirm.setText(null);
                    et_new.setText(null);
                }
            }else {
                Toast.makeText(ChangePasswordActivity.this, "请输入六位新密码", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"密码位数过少");
                et_confirm.setText(null);
                et_new.setText(null);
            }
        }else {
            Toast.makeText(ChangePasswordActivity.this, "原密码错误", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"原密码错误");
            et_confirm.setText(null);
            et_new.setText(null);
            et_used.setText(null);
        }
    }
}