package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.UserService;

public class FIndPasswordActivity2 extends AppCompatActivity {
String TAG = "FindActivity";
TextView textView;
EditText editText;
String username;
String question;
String answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_ind_password2);
        textView = findViewById(R.id.get_question);
        editText = findViewById(R.id.writeAnswer);
        Intent intent =getIntent();
        username = intent.getStringExtra("username");
        Log.i(TAG,"get username = "+username);
        UserService service = new UserService(this);
        question = service.getQuestion(username);
        textView.setText(question);
    }
    public void btn_findAns(View view){
        answer = editText.getText().toString();
        Log.i(TAG,"inputAns = "+answer);
        UserService service = new UserService(this);
        Log.i(TAG,"realAns = "+service.getAnswer(username));
        boolean flag = service.isAnswerRight(username,answer);
        Log.i(TAG,"flag = "+flag);
        if(flag){
            Intent intent = new Intent(this,GetPasswordActivity.class);
            String password = service.getPassword(username);
            intent.putExtra("password",password);
            startActivity(intent);
        }else {
            Toast.makeText(FIndPasswordActivity2.this, "答案错误", Toast.LENGTH_SHORT).show();
            editText.setText(null);
        }
    }
}