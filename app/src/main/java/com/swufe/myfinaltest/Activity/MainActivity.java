package com.swufe.myfinaltest.Activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.PageAdapter;

import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    private List<HashMap<String, String>> listItem;
    final String TAG = "MainActivity";
    String username;
    ListView listView;
    SimpleAdapter ListItemAdapter;
    String updateDate = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SharedPreferences sharedPreferences = getSharedPreferences("mytime", Activity.MODE_PRIVATE);
//        updateDate = sharedPreferences.getString("update","");
//        Log.i(TAG,"update = "+updateDate);
//        Date today = Calendar.getInstance().getTime();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        final String todayStr = simpleDateFormat.format(today);
//        Log.i(TAG,"当前时间"+todayStr);
//        //判断日期是否相同
//        if (!todayStr.equals(updateDate)) {
//            TimeService service = new TimeService(this);
//            service.deleteAll();
//            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("update", todayStr);
//            editor.commit();
//        } else {
//            Log.i(TAG, "onCreate:don't need updates");
//        }
        ViewPager viewPager = findViewById(R.id.viewpager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);
//        textView = findViewById(R.id.Main);
//        listView = findViewById(R.id.todo);
        TabLayout tabLayout = findViewById(R.id.title);
        tabLayout.setupWithViewPager(viewPager);
//        Intent intent = getIntent();
//        username = intent.getStringExtra("userName");
//        Fragment fragment = new FirstFragment();
//        Bundle bundle = new Bundle();
//        bundle.putString("username",username);
//        Log.i(TAG,"get username: "+username);
//        fragment.setArguments(bundle);
//        textView.setText(username);
//        initListView();
//        listView.setAdapter(ListItemAdapter);
//        listView.setOnItemLongClickListener(this);
//        listView.setOnItemClickListener(this);
//
//    }
//    private void initListView(){
//        listItem = new ArrayList<HashMap<String, String>>();
//        TimeService service = new TimeService(this);
//        Log.i(TAG,"get timeservice");
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
//
//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            HashMap<String,String> hashMap = (HashMap<String, String>) listView.getItemAtPosition(position);
//            String timeStr = hashMap.get("Time");
//            String todoStr = hashMap.get("Todo");
//            EditText time = view.findViewById(R.id.resetime);
//            EditText todo = view.findViewById(R.id.resething);
//            //打开界面
//            Intent intent = new Intent(this,TimeClacActivity.class);
//            intent.putExtra("Time",timeStr);
//            intent.putExtra("Todo",todoStr);
//            intent.putExtra("username",username);
//            startActivity(intent);
//        }
//
//        @Override
//        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
//            Log.i(TAG,"on_long_click");
//            //构造对话框
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("提示").setMessage("是否完成计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    Log.i(TAG,"size"+listItem.size());
//                    ListItemAdapter.notifyDataSetChanged();
//                    String time = listItem.get(position).get("time");
//                    String thing = listItem.get(position).get("todo");
//                    TimeService service =new TimeService(MainActivity.this);
//                    service.deleteone(username,time,thing);
//                    listItem.remove(position);
//                }
//            }).setNegativeButton("否",null);
//            builder.create().show();
//            return true;
//        }
//    public void btn_add(View view){
//        Intent intent = new Intent(this,TimeClacActivity.class);
//        intent.putExtra("username",username);
//        Log.i(TAG,"user = "+username);
//        startActivity(intent);
//
    }
}