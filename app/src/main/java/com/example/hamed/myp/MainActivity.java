package com.example.hamed.myp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Call> callsList;
    private CallsAdapter callsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);

        // Set Layout Manager
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Limiting the size
        recyclerView.setHasFixedSize(true);

        // Initialize list items
        init();

    }
    private void init(){
        callsList=new ArrayList<Call>();

        // Initiating Adapter
        callsAdapter=new CallsAdapter(MainActivity.this);
        recyclerView.setAdapter(callsAdapter);

        // Adding some demo data(Call Objects).
        // You can get them from your data server
        callsList.add(new Call("John","9:30 AM"));
        callsList.add(new Call("Rob","9:40 AM"));
        callsList.add(new Call("Peter","9:45 AM"));
        callsList.add(new Call("Jack","9:50 AM"));
        callsList.add(new Call("Bob","9:55 AM"));
        callsList.add(new Call("Sandy","10:00 AM"));
        callsList.add(new Call("Kate","10:05 AM"));
        callsList.add(new Call("Daniel","10:10 AM"));
        callsList.add(new Call("Roger","10:15 AM"));
        callsList.add(new Call("Sid","10:20 AM"));
        callsList.add(new Call("Kora","10:25 AM"));
        callsList.add(new Call("Nick","10:30 AM"));
        callsList.add(new Call("Rose","10:35 AM"));
        callsList.add(new Call("Mia","10:40 AM"));
        callsList.add(new Call("Scott","10:45 AM"));

        // Set items to adapter
        callsAdapter.setCallsFeed(callsList);
        callsAdapter.notifyDataSetChanged();
    }
}

