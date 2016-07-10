package com.cninter.pulltofresh.com.cninter.horizontalScrollView;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cninter.pulltofresh.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerLoadActivity extends AppCompatActivity {
    private ViewPager viewpager;
    //加载显示内容
    private List<View> content;
    //加载显示标题
    private List<String> title;
    private myViewPagerAdapter adapter;
    private LayoutInflater inflater;
    private String []item={
            "http://res3.auto.ifeng.com/s/9812/26/3/13487338875602_3.jpg",
            "http://pic26.nipic.com/20130125/9527735_124752343000_2.jpg",
            "http://img0.pcauto.com.cn/pcauto/1206/23/1999365_12.jpg",
            "http://g.hiphotos.baidu.com/zhidao/pic/item/71cf3bc79f3df8dcff8e2959cc11728b46102842.jpg",
            "http://www.sinaimg.cn/qc/photo_auto/photo/00/23/1270023/1270023_src.jpg",
            "http://dl.bizhi.sogou.com/images/2012/03/31/171526.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_load);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        inflater = LayoutInflater.from(this);
        content = new ArrayList<>();
        title = new ArrayList<>();
        adapter=new myViewPagerAdapter();
        for(int i=1;i<=6;i++){
            View view = inflater.inflate(R.layout.item,null);
            content.add(view);
            title.add("汽车"+i);

        }
        viewpager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
    class  myViewPagerAdapter extends PagerAdapter{
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = content.get(position);
            final ImageView imageView = (ImageView) view.findViewById(R.id.imagView);
            new ImageDownLoad().LoadImage(item[position], new ImageDownLoad.ImageCallBack() {
                @Override
                public void getImageContent(Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }
            });
            ((ViewPager)container).addView(view);
            return view;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0)
                title.set(0,"宝马");
            if (position==1)
                title.set(1,"比亚迪");
            if (position==2)
                title.set(2,"奔驰");
            if (position==3)
                title.set(3,"迈巴赫");
            if (position==4)
                title.set(4,"雪佛兰");
            if (position==4)
                title.set(5,"大黄蜂");


            return title.get(position);


        }

        @Override
        public int getCount() {
            return content.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            ((ViewPager)container).removeView(content.get(position));
        }
    }
}
