package com.cninter.videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ImgActivity extends AppCompatActivity {
    ImageView imageView;
    String url="http://image.baidu.com/search/detail?ct=503316480&z=&tn=baiduimagedetail&ipn=d&word=%E4%B8%AD%E5%9B%BD%E5%8D%97%E6%B5%B7&step_word=&ie=utf-8&in=&cl=2&lm=-1&st=-1&cs=3839308856,5300146&os=2828972714,315244752&simid=0,0&pn=19&rn=1&di=515619980&ln=1000&fr=&fmq=1468406692926_R&fm=index&ic=0&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&is=&istype=2&ist=&jit=&bdtype=11&gsm=0&objurl=http%3A%2F%2Fimg.gaosan.com%2Fupload%2F201607%2F6360400082327578907992657.jpg&rpstart=0&rpnum=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        imageView = (ImageView) findViewById(R.id.img);
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        imageLoader.displayImage(String.valueOf(Uri.parse(url)),imageView);


    }



}
