package com.cninter.andorid5;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CoordinatorLayoutActivity02 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator_layout02);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}
