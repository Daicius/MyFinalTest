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

public class DetailActivity extends AppCompatActivity {
String thing,time,username,detail;
EditText et_time,et_thing,et_detail;
final String  TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        thing = intent.getStringExtra("Todo");
        Log.i(TAG,"get thing = "+thing);
        time = intent.getStringExtra("Time");
        Log.i(TAG,"get time = "+time);
        username = intent.getStringExtra("username");
        Log.i(TAG,"get username = "+username);
        et_time = findViewById(R.id.et_time);
        et_thing = findViewById(R.id.et_thing);
        et_detail = findViewById(R.id.et_detail);
        et_time.setText(time);
        et_thing.setText(thing);
        TimeService service = new TimeService(this);
        detail = service.getDetail(username,time,thing);
//        Log.i(TAG, "onCreate: detail = "+detail);
        et_detail.setText(detail);
        service.deleteone(username,time,thing);
    }
    public void btn_detail(View view){
        TimeService service = new TimeService(this);
        thing = et_thing.getText().toString();
        Log.i(TAG,"new thing = "+thing);
        time = et_time.getText().toString();
        Log.i(TAG,"new time = "+time);
        detail = et_detail.getText().toString();
        if (thing.length() > 0&&time.length() > 0){
            Time time1 = new Time();
            time1.setUsername(username);
            time1.setTime(time);
            time1.setThing(thing);
            time1.setDetail(detail);
            service.add(time1);
            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtra("userName",username);
            startActivity(intent);
        }else {
            Toast.makeText(DetailActivity.this, "不能输入空值", Toast.LENGTH_SHORT).show();
        }



    }
}