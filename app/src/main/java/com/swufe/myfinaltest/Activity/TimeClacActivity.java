package com.swufe.myfinaltest.Activity;

import android.os.Bundle;
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

    }
}