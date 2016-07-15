package com.cninter.andorid5;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

     RecyclerView recyclerView;
    List<RecycleViewitem> data= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setIcon(R.mipmap.ic_launcher);
      actionBar.setDefaultDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        //设置控件的类型
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加分隔线
          recyclerView.addItemDecoration(new RecycleViewDivider());
        //添加数据
        initData();
        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,data);
        recyclerView.setAdapter(recycleViewAdapter);
        recycleViewAdapter.setItemClickListener(new RecycleViewAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {
                Toast.makeText(RecyclerViewActivity.this,"位置="+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        for (int i=0;i<20;i++){
            data.add(new RecycleViewitem(R.mipmap.ic_launcher,"msg"+i));
        }
    }


}
