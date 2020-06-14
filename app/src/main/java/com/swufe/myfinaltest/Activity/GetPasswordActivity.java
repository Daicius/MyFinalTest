package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;

public class GetPasswordActivity extends AppCompatActivity {
TextView textView;
String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_password);
        Intent intent = getIntent();
        password = intent.getStringExtra("password");
        textView = findViewById(R.id.tv_password);
        textView.setText(password);
    }
    public void btn_return(View view){
        Intent intent = new Intent(this,LoginActivity.class);
        intent.putExtra("username",intent.getStringExtra("username"));
        startActivity(intent);
    }

}