package com.cninter.pulltofresh;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class ViewPagerActivity extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener<ViewPager> {
    private PullToRefreshViewPager mPullToRefreshViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        //获得控件
        mPullToRefreshViewPager = (PullToRefreshViewPager) findViewById(R.id.pull_refresh_viewpager);
        //对刷新进行监听
        //mPullToRefreshViewPager.setOnRefreshListener(this);
        //获取view分页对象
        ViewPager vp = mPullToRefreshViewPager.getRefreshableView();
        //填充适配器
        vp.setAdapter(new SamplePagerAdapter());
        mPullToRefreshViewPager.onRefreshComplete();
    }

    @Override
    public void onRefresh(PullToRefreshBase<ViewPager> refreshView) {
        Toast.makeText(this,"刷新",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    static class SamplePagerAdapter extends PagerAdapter {

        private static int[] sDrawables = {R.mipmap.a1, R.mipmap.a2, R.mipmap.a3,
                R.mipmap.a4, R.mipmap.a5, R.mipmap.a6, R.mipmap.a7,};

        // 获取要滑动的控件的数量
        @Override
        public int getCount() {

            Log.i("aaa", "getCount()方法调用");
            return sDrawables.length;
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            Log.i("aaa", "instantiateItem()方法调用");
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(sDrawables[position]);

            // Now just add ImageView to ViewPager and return it
            container.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            Log.i("aaa", "==============================destroyItem方法调用"+position);
            container.removeView((View) object);
        }
        // 来判断显示的是否是同一张图片，这里我们将两个参数相比较返回即可
        @Override
        public boolean isViewFromObject(View view, Object object) {
            Log.i("aaa", "isViewFromObject方法调用");
            return view == object;
        }


    }
}
