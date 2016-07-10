package com.cninter.pulltofresh.com.cninter.horizontalScrollView;

import android.content.Entity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ${jacksen-hss} on 2016/7/3 0003.
 */
public class ImageDownLoad {
    public void LoadImage(final String path,final ImageCallBack callBack){
        final Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Bitmap bitmap = (Bitmap) msg.obj;
                Log.i("aaa","bitmap获取");
                callBack.getImageContent(bitmap);


            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                  byte[]data= HttpUtils.request(path);
                    Log.i("aaa","data的长度"+data.length);
                    Bitmap bitmap= BitmapFactory.decodeByteArray(data,0,data.length);
                    Message message=Message.obtain();
                    message.obj=bitmap;
                    handler.sendMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }).start();

    }

    public interface ImageCallBack{
        public void getImageContent(Bitmap bitmap);
    }
}
