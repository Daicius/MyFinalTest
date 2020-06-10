package com.swufe.myfinaltest.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    TextView textView;
    private List<HashMap<String, String>> listItem;
    String updateDate = "";
    final String TAG = "MainActivity";
    ListView listView;
    SimpleAdapter ListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.Main);
        listView = findViewById(R.id.todo);
        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        textView.setText(userName);
        initListView();
        listView.setAdapter(ListItemAdapter);
        listView.setOnItemLongClickListener(this);

    }
    private void initListView(){
        listItem = new ArrayList<HashMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("Time", "Time: " + i);
            map.put("Todo", "Todo: " + i);
            listItem.add(map);
        }
        ListItemAdapter = new SimpleAdapter(this, listItem,
                R.layout.activity_item,
                new String[]{"Time", "Todo"},
                new int[]{R.id.time, R.id.todo1}
        );
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
        Log.i(TAG,"on_long_click");
        //删除操作
//        listItem.remove(position);
//        ListItemAdapter.notifyDataSetChanged();
        //构造对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示").setMessage("是否完成计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listItem.remove(position);
                ListItemAdapter.notifyDataSetChanged();
            }
        }).
                setNegativeButton("否",null);
        builder.create().show();
        Log.i(TAG,"size"+listItem.size());
        return true;
    }
}