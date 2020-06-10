package com.swufe.myfinaltest.Activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import com.swufe.myfinaltest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ItemActivity extends ListActivity {
    private List<HashMap<String, String>> listItem;
    private SimpleAdapter ListItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_item);
        initListView();
        this.setListAdapter(ListItemAdapter);
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
}