package com.example.hamed.myp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ListDorehaActivity extends AppCompatActivity {
    DrawerLayout myDrawerLayout;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<Call> callsList;
    private ListDorehaAdapter callsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ///////////font
        ViewPump.init(ViewPump.builder()
                .addInterceptor(new CalligraphyInterceptor(
                        new CalligraphyConfig.Builder()
                                .setDefaultFontPath("fonts/iransans.ttf")
                                .setFontAttrId(R.attr.fontPath)
                                .build()))
                .build());
        //////////////
        setContentView(R.layout.list_dore_activity);
    Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
      actionbar.setDisplayHomeAsUpEnabled(true);
      actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        // Set Layout Manager
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // Limiting the size
        recyclerView.setHasFixedSize(true);


        // Initialize list items
        init();
       ///////////////drawer
        myDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                // set item as selected to persist highlight
                menuItem.setChecked(true);
                Toast.makeText(ListDorehaActivity.this, "ddddd", Toast.LENGTH_SHORT).show();
                // close drawer when item is tapped
                myDrawerLayout.closeDrawers();
startActivity(new Intent(ListDorehaActivity.this,Two.class));
                // Add code here to update the UI based on the item selected
                // For example, swap UI fragments here

                return true;
            }
        });
    }

    private void init() {
        callsList = new ArrayList<Call>();

        // Initiating Adapter
        callsAdapter = new ListDorehaAdapter(ListDorehaActivity.this);
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


    //////////font
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                myDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}