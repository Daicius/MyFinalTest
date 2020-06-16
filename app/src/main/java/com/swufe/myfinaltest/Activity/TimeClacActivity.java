package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
        if (todo.length() > 0 && time.length() > 0){
            Log.i(TAG,"todo :"+todo);
            Time time1 = new Time();
            time1.setThing(todo);
            time1.setTime(time);
            time1.setUsername(userName);
            TimeService timeService = new TimeService(TimeClacActivity.this);
            boolean flag = timeService.isNewTime(username,time,todo);
            Log.i(TAG, "flag = "+flag);
            if (flag){
                timeService.add(time1);
                Log.i(TAG,"username = "+time1.getUsername());
                Intent intent = new Intent(this,MainActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
            }else {
                Toast.makeText(TimeClacActivity.this, "计划相同", Toast.LENGTH_SHORT).show();
                Resething.setText(null);
                Resetime.setText(null);
            }


        }else {
            Toast.makeText(TimeClacActivity.this, "请输入计划", Toast.LENGTH_SHORT).show();
            Log.i(TAG,"no data input");
        }
    }
}