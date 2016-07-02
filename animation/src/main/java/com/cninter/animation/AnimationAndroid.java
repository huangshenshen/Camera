package com.cninter.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationAndroid extends AppCompatActivity implements View.OnClickListener{
    Button rotateButton,scaleButton,alphaButton,translateButton;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_android);
        rotateButton = (Button) this.findViewById(R.id.rotateButton);
        scaleButton = (Button) this.findViewById(R.id.scaleButton);
        translateButton = (Button) this.findViewById(R.id.translateButton);
        alphaButton = (Button) this.findViewById(R.id.alphaButton);
        image = (ImageView) this.findViewById(R.id.image);
        rotateButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        alphaButton.setOnClickListener(this);
        translateButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //淡入淡出
            case R.id.alphaButton:
                Animation animation1 = AnimationUtils.loadAnimation(
                        AnimationAndroid.this,R.anim.alpha);
                image.startAnimation(animation1);
                break;
            //旋转
            case R.id.rotateButton:
                Animation animation2 = AnimationUtils.loadAnimation(
                        AnimationAndroid.this,R.anim.rotate);
                image.startAnimation(animation2);
                break;
            //缩放
            case R.id.scaleButton:
                Animation animation3 = AnimationUtils.loadAnimation(
                        AnimationAndroid.this,R.anim.scale);
                image.startAnimation(animation3);
                break;
            //移动
            case R.id.translateButton:
                Animation animation4 = AnimationUtils.loadAnimation(
                        AnimationAndroid.this,R.anim.translate);
                image.startAnimation(animation4);
                break;
        }

    }
}
