package com.cninter.videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView) findViewById(R.id.video_view);
        //设置控制器
        videoView.setMediaController(new MediaController(this));
        //设置uri
        videoView.setVideoURI(Uri.parse("http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4"));
       //获取焦点
        videoView.requestFocus();
        //开始播放
        //videoView.start();


    }
}
