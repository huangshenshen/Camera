package com.cninter.animation;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimation extends AppCompatActivity implements View.OnClickListener{
    int flag=1;
    Button btn1,btn2;
    private ImageView imageView;
    AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frame_animation);
        btn1 = (Button) this.findViewById(R.id.btn1);
        btn2 = (Button) this.findViewById(R.id.btn2);
        imageView = (ImageView) this.findViewById(R.id.imageView);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int flag=1;
        switch (view.getId()){
            case R.id.btn1:
                imageView.setBackgroundResource(R.drawable.animation_list);
                animationDrawable = (AnimationDrawable) imageView.getBackground();

                break;
            case R.id.btn2:
                imageView.setBackgroundResource(R.drawable.animation_list1);
                animationDrawable = (AnimationDrawable) imageView.getBackground();

                break;

        }
        animationDrawable.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }).start();




    }
}
