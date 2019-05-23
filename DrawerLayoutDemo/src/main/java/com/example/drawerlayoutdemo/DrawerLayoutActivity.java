package com.example.drawerlayoutdemo;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DrawerLayoutActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        findViewById();

        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setIcon(R.drawable.ic_menu);
//        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
//        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("DrawerLayout");


        initViews();
        initViewPager();
    }



    private void initViews() {
        if(mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {
                    menuItem.setCheckable(true);
                    String title = menuItem.getTitle().toString();
                    Toast.makeText(getApplicationContext(),title,Toast.LENGTH_SHORT).show();
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home://这里使用R.id.home点击没有响应
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    private void findViewById() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        OnMenuItemClick();
        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);
        mDrawerLayout = findViewById(R.id.dl_main_drawer);
        mNavigationView = findViewById(R.id.nv_main_navigation);
    }

    private void OnMenuItemClick() {
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(getApplicationContext(),menuItem.toString(),Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<>();
        titles.add("精选");
        titles.add("体育");
        titles.add("NBA");
        titles.add("科技");
        titles.add("军事");
        titles.add("国际");
        titles.add("明星");
        titles.add("购物");
        titles.add("杂志");

        for(int i=0 ; i <  titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
        }

        List<Fragment> fragments = new ArrayList<>();
        for(int i=0 ; i <  titles.size(); i++) {
            fragments.add(new ListFragment());
        }

        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments,titles);

        mViewPager.setAdapter(fragmentAdapter);

        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);
    }
}
