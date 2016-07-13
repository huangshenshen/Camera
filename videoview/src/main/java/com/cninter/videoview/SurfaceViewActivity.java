package com.cninter.videoview;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class SurfaceViewActivity extends AppCompatActivity implements SurfaceHolder.Callback ,View.OnClickListener{
    SurfaceView surfaceView;
    Button start_btn;
    Button pause_btn;
    MediaPlayer mediaPlayer;
    SurfaceHolder surfaceHolder;
    boolean ispause = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
        start_btn = (Button) findViewById(R.id.start_btn);
        pause_btn = (Button) findViewById(R.id.pause_btn);
        start_btn.setOnClickListener(this);
        pause_btn.setOnClickListener(this);
        //设置surface属性
        //得到一个SurfaceHolder对象
        surfaceHolder = surfaceView.getHolder();
        //给SurfaceHolder设置回调函数
        surfaceHolder.addCallback(this);
        //设置SurfaceView的分辨率
        surfaceHolder.setFixedSize(320,480);
        //设置surface流的状态
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


    }
    //当surfaceview开始播放视频的时候执行这个方法

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_btn:
                mediaPlayer = new MediaPlayer();
                //设置音乐类型
             
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                //给SurfaceView建立关系
                mediaPlayer.setDisplay(surfaceHolder);
                try {
                    mediaPlayer.setDataSource(SurfaceViewActivity.this, Uri.parse("http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4"));
                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.pause_btn:
                if (!ispause){
                    mediaPlayer.pause();
                    ispause=true;
                }else{
                    mediaPlayer.start();
                    ispause = false;
                }

                break;

        }


    }
    //当surfaceview开始播放视频的时候执行这个方法
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {

    }
    //当surfaceview发生改变的时候，执行这个方法
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    //当surfaceview销毁发生变化的时候，执行的方法
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}
