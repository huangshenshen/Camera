package com.cninter.andorid5;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SwipeRefreshLayoutActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RecycleViewAdapter recycleViewAdapter;
    List<RecycleViewitem>  data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        initSwipeRefreshLayout();
        initRecycleView();

    }

    private void initRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        //设置控件的类型
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        //添加分隔线
        recyclerView.addItemDecoration(new RecycleViewDivider());
        //添加数据
        initData();
        recycleViewAdapter = new RecycleViewAdapter(this,data);
        recyclerView.setAdapter(recycleViewAdapter);

        //添加item监听
        recycleViewAdapter.setItemClickListener(new RecycleViewAdapter.OnRecycleViewItemClickListener() {
            @Override
            public void OnItemClickListener(View v, int position) {
                Log.i("aaa","position="+position);
                Toast.makeText(SwipeRefreshLayoutActivity.this, "点击的位置是:"+position, Toast.LENGTH_SHORT).show();
            }


        });

    }

    private void initData() {
        for(int i=0;i<20;i++){
            data.add(new RecycleViewitem(R.mipmap.ic_launcher,"msg"+i));
        }
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        //设置背景条背景颜色
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(android.R.color.black);
        //设置滚动条的滚动颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.white,android.R.color.holo_blue_bright,android.R.color.holo_red_dark,android.R.color.holo_green_dark,android.R.color.holo_orange_dark);
        //进度条的偏移量
        swipeRefreshLayout.setProgressViewOffset(false,0,20);
        //设置监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //请求数据
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List<RecycleViewitem>  list = new ArrayList<RecycleViewitem>();
                        for(int i=0;i<5;i++){
                            list.add(new RecycleViewitem(R.drawable.pic,"new data"+i));
                        }
                        //把数据加到新数据里面
                        list.addAll(data);
                        //把旧数据清空
                        data.removeAll(data);
                        data.addAll(list);
                        recycleViewAdapter.notifyDataSetChanged();
                        //停止刷新
                        swipeRefreshLayout.setRefreshing(false);


                    }
                }, 5000);


            }
        });

    }
}
