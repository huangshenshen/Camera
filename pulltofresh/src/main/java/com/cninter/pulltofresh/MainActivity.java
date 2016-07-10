package com.cninter.pulltofresh;

import android.app.ListActivity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

public class MainActivity extends ListActivity {
    PullToRefreshListView  mpullToRefreshListView;
    private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler" };
    int falg=0;
    LinkedList linkedList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpullToRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);
        linkedList=new LinkedList();
        linkedList.addAll(Arrays.asList(mStrings));
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,linkedList);
        mpullToRefreshListView.setAdapter(adapter);
        mpullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                falg=1;

                linkedList.addFirst("前面添加1个数据");//没有耗时操作会立马进入
                new GetDataTask().execute();
                Toast.makeText(MainActivity.this,"onPullDownToRefresh",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                falg=2;
                linkedList.addLast("后面添加2个数据");
                new GetDataTask().execute();
                Toast.makeText(MainActivity.this,"onPullUpToRefresh",Toast.LENGTH_SHORT).show();
            }
        });



    }
    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        @Override
        protected void onPostExecute(String[] result) {
            if (falg==1){
                linkedList.addFirst("前面添加一个数据");
            }
            if (falg==2){
                linkedList.addLast("后面添加一个数据");
            }


            adapter.notifyDataSetChanged();

            // Call onRefreshComplete when the list has been refreshed.
            mpullToRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }
}
