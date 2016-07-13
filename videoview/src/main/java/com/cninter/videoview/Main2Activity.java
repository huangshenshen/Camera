package com.cninter.videoview;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import java.net.URL;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    VideoView videoView;
    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        playVideo();
        initListener();
    }
    private void initListener(){
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }


    private void playVideo() {
        if (videoView!=null){
            videoView.setVideoURI(Uri.parse("http://vf1.mtime.cn/Video/2015/03/20/mp4/150320094140850937_480.mp4"));
            videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();

        }

    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.my_video_view);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
    }
    boolean isFullScreen=false;
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                if (!isFullScreen){
                    //全屏
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                    layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                    videoView.setLayoutParams(layoutParams);
                    btn1.setText("窗口模式");
                    isFullScreen=true;


                }else{
                    DisplayMetrics dispalyMetrics = new DisplayMetrics();
                    getWindowManager().getDefaultDisplay().getMetrics(dispalyMetrics);
                    int screenwidth = dispalyMetrics.widthPixels;
                    int screenheith = dispalyMetrics.heightPixels;
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenwidth,screenheith/2);
                    layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
                    videoView.setLayoutParams(layoutParams);
                    btn1.setText("全屏模式");
                    isFullScreen = false;

                }

                break;
            case R.id.btn2:
                //控制横竖屏
                if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }else {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }

                break;

        }

    }
    //保存当前进度
    static  int currentPosition;

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
        currentPosition = videoView.getCurrentPosition();

    }

    @Override
    protected void onResume() {
        super.onResume();
        videoView.seekTo(currentPosition);
        videoView.start();

    }
}
