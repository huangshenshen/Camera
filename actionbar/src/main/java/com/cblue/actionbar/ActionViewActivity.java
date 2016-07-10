package com.cblue.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ActionViewActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionview_menu,menu);
        //获得menu菜单的item对象
        MenuItem menuItem = menu.findItem(R.id.search);
        //获得item对象中的SearchView对象
        searchView =(SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           //当我们查询的文字提交的时候，执行这个方法
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("aaa","提交的字符串:"+query);
                //设置SearchView不会重复提交
                searchView.setIconified(true);
                return true;
            }
           //当我们查询的文字发生改变的时候，执行这个方法
            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("aaa","查询修改的字符串:"+newText);
                return true;
            }
        });



        return super.onCreateOptionsMenu(menu);
    }
}
