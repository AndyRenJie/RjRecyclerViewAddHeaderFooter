package com.rocky.andyren.rjrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mainRecyclerView;
    private MainAdapter adapter;
    private View headerView;
    private View footerView;
    public static final int HEADER_VIEW_TYPE = 1;
    public static final int FOOTER_VIEW_TYPE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        headerView = LayoutInflater.from(this).inflate(R.layout.header,null);
        headerView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
        footerView = LayoutInflater.from(this).inflate(R.layout.footer,null);
        footerView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
        mainRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        fillData();
    }

    private void fillData() {
        ArrayList<String>list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("item_" + i);
        }
        ArrayList <ViewBean> headerInfos = new ArrayList<>();
        headerInfos.add(new ViewBean(headerView,HEADER_VIEW_TYPE));
        ArrayList <ViewBean> footerInfos = new ArrayList<>();
        footerInfos.add(new ViewBean(footerView,FOOTER_VIEW_TYPE));

        adapter = new MainAdapter(this,list,headerInfos,footerInfos);
        mainRecyclerView.setAdapter(adapter);
    }
}
