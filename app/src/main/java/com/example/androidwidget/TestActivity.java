package com.example.androidwidget;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

public class TestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        LayoutInflaterCompat.setFactory2(LayoutInflater.from(this), new LayoutInflater.Factory2() {

            @Override
            public View onCreateView(String name, Context context, AttributeSet attrs) {
                return null;
            }

            @Override
            public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
                if (name.equals("TextView")) {
                    Button button = new Button(context,attrs);
                    Log.d("zhangya", "onCreateView1: ");
                    return button;
                }
                return null;
            }
        });
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_main);
    }
}
