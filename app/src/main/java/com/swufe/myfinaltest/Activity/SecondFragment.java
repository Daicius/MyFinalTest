package com.swufe.myfinaltest.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.swufe.myfinaltest.R;
import com.swufe.myfinaltest.Service.TimeService;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecondFragment extends Fragment implements View.OnClickListener {
    TextView tv_user,tv_rest;
    Button logout,more;
    String username;
    int restthing;
    final String TAG = "SecondFragment";
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
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
        View view = inflater.inflate(R.layout.fragment_second2, container, false);
        tv_user = view.findViewById(R.id.tv_username);
        tv_rest = view.findViewById(R.id.tv_needtodo);
        username = getActivity().getIntent().getStringExtra("userName");
        Log.i(TAG,"username = "+username);
        tv_user.setText(username);
        TimeService service = new TimeService(getContext());
        restthing = service.resthing(username);
        Log.i(TAG,"rest = "+restthing);
        tv_rest.setText(restthing+"件");
        logout = view.findViewById(R.id.btn_logout);
        more = view.findViewById(R.id.btn_changePassword);
        logout.setOnClickListener(this);
        more.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_logout){
            Intent intent = new Intent(getContext(),LoginActivity.class);
            startActivity(intent);
        }else if (v.getId() == R.id.btn_changePassword){
            Intent intent = new Intent(getContext(),ChangePasswordActivity.class);
            intent.putExtra("username",username);
            startActivity(intent);
        }
    }
}