package com.cninter.pulltofresh;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.handmark.pulltorefresh.extras.viewpager.PullToRefreshViewPager;
import com.handmark.pulltorefresh.library.PullToRefreshBase;

public class ViewPageDemo extends AppCompatActivity implements PullToRefreshBase.OnRefreshListener<ViewPager>{
    private PullToRefreshViewPager mPullToRefreshViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_page_demo);
        mPullToRefreshViewPager = (PullToRefreshViewPager) findViewById(R.id.viewpager1);
        mPullToRefreshViewPager.setOnRefreshListener(this);
        ViewPager vp = mPullToRefreshViewPager.getRefreshableView();
        vp.setAdapter(new Myadapter());
        mPullToRefreshViewPager.onRefreshComplete();

    }
    class  Myadapter extends PagerAdapter{
        int []sMipmap={R.mipmap.a1,R.mipmap.a2,R.mipmap.a3,R.mipmap.a4,R.mipmap.a5,R.mipmap.a6,R.mipmap.a7
        };

        //获取sMitmap的长度
        @Override
        public int getCount() {
            return sMipmap.length;
        }
        //判断是否是同一张照片
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView=new ImageView(getApplicationContext());

            imageView.setImageResource(sMipmap[position]);
            container.addView(imageView,ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView((View)object);


        }
    }

    @Override
    public void onRefresh(PullToRefreshBase<ViewPager> refreshView) {
        Toast.makeText(this,"正在刷新",Toast.LENGTH_SHORT).show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        mPullToRefreshViewPager.onRefreshComplete();
    }
}
