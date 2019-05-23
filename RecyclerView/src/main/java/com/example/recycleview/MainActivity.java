package com.example.recycleview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recycleview.adapter.HomeAdapter;
import com.example.recycleview.base.BaseMvpActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MainActivity extends BaseMvpActivity {
    @BindView(R.id.tv_main)
    TextView textView;
//    @BindView(R.id.rv_main)
    RecyclerView mRecyclerView;
    HomeAdapter mHomeAdapter;

    List<String> mList;


    @Override
    protected int attachLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        initData();
        initView();
    }

    private void initData() {
        mList = new ArrayList<String>();
        for(int i =1; i< 5; i++) {
            mList.add(i+"");
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.rv_main);
        setRvContent();
        setListView();
    }

    private void setRvContent() {
        if (mList.size() > 0 ) {
            textView.setVisibility(View.GONE);
        }else {
            textView.setVisibility(View.VISIBLE);
        }
    }

    void setListView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mHomeAdapter = new HomeAdapter(this,mList);
        initClickListener();
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    void initClickListener() {
        mHomeAdapter.setOnItemClickListener(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "click :" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view,final int position) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("确认删除")
                        .setNegativeButton("取消",null)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mHomeAdapter.removeData(which);
                            }
                        })
                        .show();
            }
        });
    }

}
