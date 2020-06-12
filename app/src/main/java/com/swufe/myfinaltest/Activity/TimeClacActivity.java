package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.Time;
import com.swufe.myfinaltest.Service.TimeService;

public class TimeClacActivity extends AppCompatActivity {
EditText Resetime,Resething;
    String username;
final String TAG = "TimeClacActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_clac);
        Resething = findViewById(R.id.resething);
        Resetime = findViewById(R.id.resetime);
        TimeService timeService = new TimeService(this);
        timeService.deleteAll();
        Intent intent = getIntent();
        String todo = intent.getStringExtra("Todo");
        String time = intent.getStringExtra("Time");
        username = intent.getStringExtra("username");
        Resetime.setText(time);
        Resething.setText(todo);
        Log.i(TAG,"get username: "+username);
    }
    public void btnReset(View view){
        String todo;
        String time;
        String userName;
        Resething = findViewById(R.id.resething);
        Resetime = findViewById(R.id.resetime);
        userName = username;
        todo = Resething.getText().toString();
        time = Resetime.getText().toString();
        Log.i(TAG,"todo :"+todo);
        Time time1 = new Time();
        time1.setThing(todo);
        time1.setTime(time);
        time1.setUsername(userName);
        TimeService timeService = new TimeService(TimeClacActivity.this);
        timeService.add(time1);
        Log.i(TAG,"username = "+time1.getUsername());
        Intent intent = new Intent(this,TestActivity2.class);
        startActivity(intent);
    }
}