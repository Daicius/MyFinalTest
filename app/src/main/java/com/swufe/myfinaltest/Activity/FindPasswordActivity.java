package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;

public class FindPasswordActivity extends AppCompatActivity {
    String username;
EditText editText;
String TAG = "FindPassword";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_password);
    }
    public void btn_find(View view){
        editText = findViewById(R.id.et_find);
        username = editText.getText().toString();
        Log.i(TAG,"username = "+username);
        Intent intent = new Intent(this,FIndPasswordActivity2.class);
        intent.putExtra("username",username);
        startActivity(intent);
    }
}