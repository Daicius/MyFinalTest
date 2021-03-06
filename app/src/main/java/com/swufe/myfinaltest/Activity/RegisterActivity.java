package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.User;
import com.swufe.myfinaltest.Service.UserService;

public class RegisterActivity extends AppCompatActivity {
EditText code;
EditText codeConfirm;
EditText userName;
EditText question,answer;
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
        question = findViewById(R.id.question);
        answer = findViewById(R.id.answer);
        UserService uService = new UserService(RegisterActivity.this);
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
            }else if (!uService.isNewRegister(username)){
                Toast.makeText(this,"用户名相同",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"注册失败");
                userName.setText(null);
                code.setText(null);
                codeConfirm.setText(null);
            }else if(question.getText().toString().length() == 0 || answer.getText().toString().length() == 0){
                Toast.makeText(this,"输入问题",Toast.LENGTH_SHORT).show();
                Log.i(TAG,"注册失败");
            }  else{
                Log.i(TAG,"注册成功");
                Log.i(TAG,"answer = "+answer.getText().toString());
                Log.i(TAG,"question = "+question.getText().toString());
                User user=new User();
                user.setUsername(username);
                user.setPassword(code1);
                user.setAnswer(answer.getText().toString());
                user.setQuestion(question.getText().toString());
                uService.register(user);
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("username",username);
                intent.putExtra("code",code1);
                startActivity(intent);
            }
        }

    }

}