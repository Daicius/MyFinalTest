package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;

public class TimeClacActivity extends AppCompatActivity {
EditText Resetime,Resething;
final String TAG = "TimeClacActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_clac);
        Resething = findViewById(R.id.resething);
        Resetime = findViewById(R.id.resetime);
        Intent intent = getIntent();
        String todo = intent.getStringExtra("Todo");
        String time = intent.getStringExtra("Time");
        Resetime.setText(time);
        Resething.setText(todo);
    }
    public void btnReset(View view){
        String todo;
        String time;
        Resething = findViewById(R.id.resething);
        Resetime = findViewById(R.id.resetime);
        todo = Resething.getText().toString();
        time = Resetime.getText().toString();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("Todo",todo);
        intent.putExtra("Time",time);
        startActivity(intent);
    }
}