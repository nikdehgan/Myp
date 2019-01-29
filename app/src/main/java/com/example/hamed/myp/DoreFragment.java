package com.example.hamed.myp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DoreFragment extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Call> callsList;
    private ListDorehaAdapter callsAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view= inflater.inflate(R.layout.fragment_dore, null);
//
//        // Replace 'android.R.id.list' with the 'id' of your RecyclerView
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
//
//        // Set Layout Manager
     linearLayoutManager = new LinearLayoutManager(view.getContext());
      recyclerView.setLayoutManager(linearLayoutManager);
//
//        // Limiting the size
        recyclerView.setHasFixedSize(true);
//
//
//        // Initialize list items
       init();
   return view;
    }
    private void init() {
        callsList = new ArrayList<Call>();

        // Initiating Adapter
        callsAdapter = new ListDorehaAdapter(getContext());
        recyclerView.setAdapter(callsAdapter);

        // Adding some demo data(Call Objects).
        // You can get them from your data server
        callsList.add(new Call("حامد", "9:30 AM", R.drawable.mypic));
        callsList.add(new Call("علی", "9:40 AM", R.drawable.a2));
        callsList.add(new Call("Peter", "9:45 AM", R.drawable.a3));
        callsList.add(new Call("Jack", "9:50 AM", R.drawable.a1));
        callsList.add(new Call("Bob", "9:55 AM", R.drawable.a4));
        callsList.add(new Call("Sandy", "10:00 AM", R.drawable.a5));
        callsList.add(new Call("Kate", "10:05 AM", R.drawable.mypic));
        callsList.add(new Call("Daniel", "10:10 AM", R.drawable.a1));
        callsList.add(new Call("Roger", "10:15 AM", R.drawable.a2));
        callsList.add(new Call("Sid", "10:20 AM", R.drawable.a3));
        callsList.add(new Call("Kora", "10:25 AM", R.drawable.a4));
        callsList.add(new Call("Nick", "10:30 AM", R.drawable.a5));
        callsList.add(new Call("Rose", "10:35 AM", R.drawable.mypic));
        callsList.add(new Call("Mia", "10:40 AM", R.drawable.a1));
        callsList.add(new Call("Scott", "10:45 AM", R.drawable.a2));

        // Set items to adapter
        callsAdapter.setCallsFeed(callsList);
        callsAdapter.notifyDataSetChanged();
    }
}
