package com.swufe.myfinaltest.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.swufe.myfinaltest.R;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
    TextView textView;
    private List<HashMap<String, String>> listItem;
    final String TAG = "MainActivity";
    String username;
    ListView listView;
    SimpleAdapter ListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.Main);
        listView = findViewById(R.id.todo);
        Intent intent = getIntent();
        username = intent.getStringExtra("userName");
        Log.i(TAG,"get username: "+username);
        textView.setText(username);
//        initListView();
//        listView.setAdapter(ListItemAdapter);
        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);

    }
//    private void initListView(){
//        listItem = new ArrayList<HashMap<String, String>>();
//        TimeService service = new TimeService(this);
//        for (Time time : service.listuser(username)){
//            HashMap<String,String> hashMap = new HashMap<>();
//            hashMap.put("todo",time.getThing());
//            Log.i("TAG",time.getThing());
//            hashMap.put("time",time.getTime());
//            listItem.add(hashMap);
//        }
//        ListItemAdapter = new SimpleAdapter(this, listItem,
//                R.layout.activity_item,
//                new String[]{"time", "todo"},
//                new int[]{R.id.time, R.id.todo1}
//        );
//    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HashMap<String,String> hashMap = (HashMap<String, String>) listView.getItemAtPosition(position);
        String timeStr = hashMap.get("Time");
        String todoStr = hashMap.get("Todo");
        EditText time = view.findViewById(R.id.resetime);
        EditText todo = view.findViewById(R.id.resething);

        //打开界面

        Intent intent = new Intent(this,TimeClacActivity.class);
        intent.putExtra("Time",timeStr);
        intent.putExtra("Todo",todoStr);
        startActivity(intent);
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
        }).setNegativeButton("否",null);
        builder.create().show();
        Log.i(TAG,"size"+listItem.size());
        return true;
    }
    public void btn_add(View view){
        Intent intent = new Intent(this,TimeClacActivity.class);
        intent.putExtra("username",username);
        Log.i(TAG,"user = "+username);
        startActivity(intent);

    }

}