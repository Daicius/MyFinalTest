package com.swufe.myfinaltest.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.Time;
import com.swufe.myfinaltest.Service.TimeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment implements AdapterView.OnItemLongClickListener, View.OnClickListener, AdapterView.OnItemClickListener {
    TextView textView;
    private List<HashMap<String, String>> listItem;
    String username;
    ListView listView;
    SimpleAdapter ListItemAdapter;
    String updateDate = "";
    Button button;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    final String TAG = "FirstFragment" ;
    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.btn_add);
         textView = view.findViewById(R.id.Main);
         listView = view.findViewById(R.id.todo);
        username = getActivity().getIntent().getStringExtra("userName");
        Log.i(TAG,"username = "+username);
        initListView();
        listView.setAdapter(ListItemAdapter);
        button.setOnClickListener(this);
        listView.setOnItemLongClickListener(this);
        listView.setOnItemClickListener(this);
         return  view;
    }
        private void initListView(){
        listItem = new ArrayList<HashMap<String, String>>();
        TimeService service = new TimeService(getContext());
            username = getActivity().getIntent().getStringExtra("userName");
            Log.i(TAG,"init USER"+username);
            Log.i(TAG,"get timeservice");
        for (Time time : service.listuser(username)){
            HashMap<String,String> hashMap = new HashMap<>();
            hashMap.put("todo",time.getThing());
            Log.i("TAG",time.getThing());
            hashMap.put("time",time.getTime());
            listItem.add(hashMap);
        }
        ListItemAdapter = new SimpleAdapter(getContext(), listItem,
                R.layout.activity_item,
                new String[]{"time", "todo"},
                new int[]{R.id.time, R.id.todo1}
        );
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(),TimeClacActivity.class);
        intent.putExtra("username",username);
        Log.i(TAG,"user = "+username);
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                    Log.i(TAG,"on_long_click");
            //构造对话框
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle("提示").setMessage("是否完成计划").setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.i(TAG,"size"+listItem.size());
                    ListItemAdapter.notifyDataSetChanged();
                    String time = listItem.get(position).get("time");
                    String thing = listItem.get(position).get("todo");
                    TimeService service =new TimeService(getContext());
                    service.deleteone(username,time,thing);
                    Intent intent = new Intent(getContext(),MainActivity.class);
                    intent.putExtra("userName",username);
                    startActivity(intent);
//                    listItem.remove(position);
                }
            }).setNegativeButton("否",null);
            builder.create().show();
            return true;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.i(TAG,"on_short_click");
        String timeStr = listItem.get(position).get("time");
        String todoStr = listItem.get(position).get("todo");
            //打开界面
            Intent intent = new Intent(getContext(),DetailActivity.class);
            intent.putExtra("Time",timeStr);
            intent.putExtra("Todo",todoStr);
            intent.putExtra("username",username);
            Log.i(TAG,"time = "+timeStr);
            Log.i(TAG,"Thing = "+todoStr);
            Log.i(TAG,"username = "+username);
            startActivity(intent);
    }
}