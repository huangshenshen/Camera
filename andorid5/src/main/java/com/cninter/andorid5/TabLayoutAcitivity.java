package com.cninter.andorid5;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TabLayoutAcitivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    MyPagerAdapter myadapter;
    String tilte[]=new String[10];
    String content[]=new String[10];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout_acitivity);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_lay_tly);
        initData();
        for (int i=0;i<tilte.length;i++){
            tabLayout.addTab(tabLayout.newTab().setText(tilte[i]));

        }
        myadapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myadapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initData() {
        for(int i=0;i<10;i++){
              tilte[i]="tilte" +i;
            content[i]="content"+i;
        }
        
    }
    class  MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("CONTENT",content[position]);
            fragment.setArguments(bundle);
            return  fragment;

        }

        @Override
        public int getCount() {
            return tilte.length;
        }
    }

}
