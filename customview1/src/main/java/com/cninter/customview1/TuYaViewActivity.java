package com.cninter.customview1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class TuYaViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tu_ya_view);
        //得到屏幕的宽高
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        TuYaView tuYaView = new TuYaView(TuYaViewActivity.this,displayMetrics.widthPixels,displayMetrics.heightPixels);
        setContentView(tuYaView);

    }
}
