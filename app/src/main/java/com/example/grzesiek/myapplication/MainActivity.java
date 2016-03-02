package com.example.grzesiek.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
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

        List<Event> events  = new ArrayList<>();
        events.add(new Event(categories.get(0), new Date(), new Date(), "#youtube"));
        events.add(new Event(categories.get(1), new Date(), new Date(), "#dinner"));
        events.add(new Event(categories.get(2), new Date(), new Date(), "#pwr"));
        events.add(new Event(categories.get(1), new Date(), new Date(), "#youtube"));
        events.add(new Event(categories.get(2), new Date(), new Date(), "#dinner"));
        events.add(new Event(categories.get(0), new Date(), new Date(), "#pwr"));
        events.add(new Event(categories.get(0), new Date(), new Date(), "#youtube"));
        events.add(new Event(categories.get(2), new Date(), new Date(), "#dinner"));
        events.add(new Event(categories.get(1), new Date(), new Date(), "#pwr"));



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        viewPager.setCurrentItem(4);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        RecyclerView rv;
        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        RVAdapter rv_adapter = new RVAdapter(events);
        rv.setAdapter(rv_adapter);

        PagerAdapter p_adapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return false;
            }
        };

        viewPager.setAdapter(p_adapter);

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

    private void initalizeData(){

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DayTab(), "21/02");
        adapter.addFrag(new DayTab(), "22/02");
        adapter.addFrag(new DayTab(), "23/02");
        adapter.addFrag(new DayTab(), "YESTERDAY");
        adapter.addFrag(new DayTab(), "TODAY");
        adapter.addFrag(new DayTab(), "TOMORROW");
        adapter.addFrag(new DayTab(), "27/02");
        adapter.addFrag(new DayTab(), "28/02");
        adapter.addFrag(new DayTab(), "29/02");
        adapter.addFrag(new DayTab(), "30/02");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
