package com.example.grzesiek.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_wimt);
        getSupportActionBar().setTitle(null);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Wasting time", "#FF4500"));
        categories.add(new Category("Preparing food", "#32CD32"));
        categories.add(new Category("Working", "#FFA500"));

        List<Activity> activities  = new ArrayList<>();
        activities.add(new Activity(categories.get(0), new Date(), new Date(), "#youtube"));
        activities.add(new Activity(categories.get(1), new Date(), new Date(), "#dinner"));
        activities.add(new Activity(categories.get(2), new Date(), new Date(), "#pwr"));
        activities.add(new Activity(categories.get(1), new Date(), new Date(), "#youtube"));
        activities.add(new Activity(categories.get(2), new Date(), new Date(), "#dinner"));
        activities.add(new Activity(categories.get(0), new Date(), new Date(), "#pwr"));
        activities.add(new Activity(categories.get(0), new Date(), new Date(), "#youtube"));
        activities.add(new Activity(categories.get(2), new Date(), new Date(), "#dinner"));
        activities.add(new Activity(categories.get(1), new Date(), new Date(), "#pwr"));

        //setContentView(R.layout.recycler_view);

        RecyclerView rv;
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        RVAdapter adapter = new RVAdapter(activities);
        rv.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        android.graphics.drawable.Drawable drawable = menu.findItem(R.id.action_statistics).getIcon();
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        drawable = menu.findItem(R.id.action_settings).getIcon();
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        drawable = menu.findItem(R.id.action_add).getIcon();
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(android.graphics.Color.WHITE, android.graphics.PorterDuff.Mode.SRC_ATOP);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
