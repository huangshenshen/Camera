package com.cninter.pulltofresh;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class ViewPager2Activtiy extends AppCompatActivity  implements PullToRefreshBase.OnRefreshListener<ViewPager> {
    private PullToRefreshViewPager mpullToRefreshViewPager;
    private PagerAdapter  pagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2_activtiy);
        mpullToRefreshViewPager = (PullToRefreshViewPager) findViewById(R.id.pulltorefreshhu);
        mpullToRefreshViewPager.setOnRefreshListener(this);
        ViewPager vp=mpullToRefreshViewPager.getRefreshableView();
        vp.setAdapter(new mypagerAdappter());
        mpullToRefreshViewPager.onRefreshComplete();
    }
    static class  mypagerAdappter extends PagerAdapter{
        static int[] a={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a7,};
        @Override
        public int getCount() {
            return a.length;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(container.getContext());
            imageView.setImageResource(a[position]);
            container.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View) object);


        }
    }
    @Override
    public void onRefresh(PullToRefreshBase<ViewPager> refreshView) {
        Log.i("aaa","====================================");
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
}
