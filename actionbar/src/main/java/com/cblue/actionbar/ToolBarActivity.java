package com.cblue.actionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ToolBarActivity extends AppCompatActivity {

    Button button;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这是设置ActionBar隐藏的代码方法，一定在布局加载代码之前
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_tool_bar);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        //设置导航
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Log.i("aaa","导航");
            }
        });

        //设置logo
       // toolbar.setLogo(R.mipmap.ic_launcher);
        //设置标题
        toolbar.setTitle("title");
        //设置子标题
        toolbar.setSubtitle("subtitle");
        //设置右侧菜单
        toolbar.inflateMenu(R.menu.toolbar_menu);
      //设置右侧菜单的监听
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.search1:
                        Log.i("aaa","search1");
                        break;

                    case R.id.search2:
                        Log.i("aaa","search2");
                        break;

                    case R.id.search3:
                        Log.i("aaa","search3");
                        break;

                    case R.id.search4:
                        Log.i("aaa","search4");
                        break;
                }

                return true;
            }
        });





    }
}
