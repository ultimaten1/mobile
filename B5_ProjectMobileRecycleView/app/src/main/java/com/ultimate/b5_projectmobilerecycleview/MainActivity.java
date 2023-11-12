package com.ultimate.b5_projectmobilerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvContent;
    private TitleListAdapter adapter;
    private ArrayList<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleList = new ArrayList<>();
        titleList.add("Trần Thành Đạt");
        titleList.add("T1 > JDG");

        Log.d("ggg", titleList.toString());
        System.out.println("lm");
        rcvContent = findViewById(R.id.rcvContent);
        adapter = new TitleListAdapter(this, titleList);
        rcvContent.setAdapter(adapter);
        rcvContent.setLayoutManager(new LinearLayoutManager(this));
    }
}