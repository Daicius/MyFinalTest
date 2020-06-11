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
        Log.i(TAG,"todo :"+todo);
        Time time1 = new Time();
        time1.setThing(todo);
        time1.setTime(time);
        TimeService timeService = new TimeService(TimeClacActivity.this);
        timeService.add(time1);
        Log.i(TAG,"todo :"+todo);
        Intent intent = new Intent(this,TestActivity2.class);
        startActivity(intent);
    }
}