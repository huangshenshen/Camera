package com.cninter.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {
    private Button rotateButton;
    private Button scaleButton;
    private Button translateButton;
    private Button alphaButton;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件

        rotateButton = (Button) this.findViewById(R.id.rotateButton);
        scaleButton = (Button) this.findViewById(R.id.scaleButton);
        translateButton = (Button) this.findViewById(R.id.translateButton);
        alphaButton = (Button) this.findViewById(R.id.alphaButton);
        image = (ImageView) this.findViewById(R.id.image);
        //设置监听
        rotateButton.setOnClickListener(new RotateButtonListener());
        scaleButton.setOnClickListener(new ScaleButtonListener());
        translateButton.setOnClickListener(new TranslateButoonListerner());
        alphaButton.setOnClickListener(new AlphaButtonListener());

    }
    //淡入淡出
    class AlphaButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //创建一个AnimationSet对象，参数为Boolean型，
            //true表示使用Animation的interpolator,false则使用自己的
            AnimationSet animationSet = new AnimationSet(true);
            //创建一个AlphaAnimation对象，参数从完全的透明度,到完全的不透明
            AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
            //设置动画时间
            alphaAnimation.setDuration(500);
            //将alphaAnimation对象添加到AnimationSet中
            animationSet.addAnimation(alphaAnimation);
            //使用ImageView的startAnimation方法执行动画
            image.startAnimation(animationSet);

        }

    }
    class RotateButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //创建一个AnimationSet对象，参数为Boolean型，
            //true表示使用Animation的interpolator,false则使用自己的
            AnimationSet animationSet  = new AnimationSet(true);
            /*
             参数1：从哪个旋转角度开始
            参数2：转到什么角度
            后四个参数用于设置围绕着旋转的圆的圆心在哪里
            参数3：确定x轴坐标的类型，有ABSOLUT 绝对坐标、RELATIVE_TO_SELF相对于自身坐标、
            RELATIVE_TO_PARENT相对于父控件的坐标
            参数4：x轴的值,0.5f表，名是以自身这控件的一半长度为X轴
            参数5：确定y轴坐标的类型
            参数6：y轴的值，0.5f表明是以自身这个控件一半长度为X轴

             */
            RotateAnimation rotateAnimation = new RotateAnimation(0,360,
                    Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
            rotateAnimation.setDuration(1000);
            animationSet.addAnimation(rotateAnimation);
            image.startAnimation(animationSet);
        }
    }
    class ScaleButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            AnimationSet animationSet = new AnimationSet(true);
            /*
             参数1：x轴的初始值
            参数2：x轴收缩后的值
            参数3：y轴的初始化
            参数4：y轴收缩后的值
            参数5：确定x轴坐标的类型
            参数6：x轴的值，0.5f表明是以自身这个控件一半长度为X轴
            参数7：确定y轴坐标的类型
            参数8：y轴的值，0.5f表明是以自身这个控件的一般长度为X轴
             */
            ScaleAnimation scaleAnimation = new ScaleAnimation(0,1.0f,0,1.0f,
                    Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
            scaleAnimation.setDuration(3000);
            animationSet.addAnimation(scaleAnimation);
            image.startAnimation(animationSet);
        }
    }
    class TranslateButoonListerner implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            AnimationSet animationSet = new AnimationSet(true);
            /**
             * 参数1，2:X轴开始的位置
             * 参数3,4:Y轴开始的位置
             * 参数4,5：X轴的结束位置
             * 参数7,8：Y轴的结束位置
             */
            TranslateAnimation translateAnimation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0.5f,
                    Animation.RELATIVE_TO_SELF,0f,Animation.RELATIVE_TO_SELF,0.5f);
            translateAnimation.setDuration(1000);
            animationSet.addAnimation(translateAnimation);
            image.startAnimation(animationSet);



        }
    }

}