package com.example.tablayoutdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        mTabLayout = findViewById(R.id.tabs);
        mViewPager = findViewById(R.id.viewpager);
        initViewPager();
    }

    private void initViewPager() {
        List<String> titles = new ArrayList<String>();
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
