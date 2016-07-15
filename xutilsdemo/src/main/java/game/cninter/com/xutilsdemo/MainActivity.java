package game.cninter.com.xutilsdemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheMode;
import com.lzy.okhttputils.callback.StringCallback;
import com.lzy.okhttputils.https.HttpsUtils;

import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    String url="http://g.hiphotos.baidu.com/image/pic/item/6c224f4a20a446230761b9b79c22720e0df3d7bf.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.image_view);
        textView = (TextView) findViewById(R.id.text_view);
       //Glide的简单使用
        Glide.with(MainActivity.this).load(url).into(imageView);
       initdata();

       
    }

    private void initdata() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //xUtils的HttpUtils

               HttpUtils http = new HttpUtils();
                            //请求方式                 请求的url                       //回调的类型
                http.send(HttpRequest.HttpMethod.GET, "http://www.sina.com", new RequestCallBack<String>() {
                    //返回成功执行的方法
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        //responseInfo.result返回的结果
                        Log.i("aaa",responseInfo.result);
                    }
                    //返回失败执行的方法
                    @Override
                    public void onFailure(HttpException e, String s) {

                    }
                });




            }
        }).start();
    }
}
