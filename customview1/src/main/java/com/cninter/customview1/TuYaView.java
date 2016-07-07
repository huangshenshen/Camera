package com.cninter.customview1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ${jacksen-hss} on 2016/6/30 0030.
 */
public class TuYaView extends View {
    //画板
    private Canvas canvas;
    //纸
    Bitmap bitmap;
    //笔
    private Paint paint;
    //路径
    private Path path;
    //临时保存
    private float mx,my;


    public TuYaView(Context context,int screenWith,int screenHeight){
        super(context);
        //我需要一个画板  还需要纸，还需要笔
        bitmap= Bitmap.createBitmap(screenWith,screenHeight,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
        paint = new Paint();
        paint.setAntiAlias(true);//设置平滑曲线
        paint.setStyle(Paint.Style.STROKE);//画实线
        paint.setStrokeWidth(5);//设置实线宽度
        paint.setColor(Color.BLUE);

    }
    public TuYaView(Context context) {
        super(context);
    }

    public TuYaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TuYaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //单点触控


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        int action=event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
                path=new Path();
                path.moveTo(x,y);
                mx=x;
                my=y;


                break;
            case MotionEvent.ACTION_MOVE:
                float dx=Math.abs(x-mx);
                float dy= Math.abs(y-mx);
                if (dx>2||dy>2){
                    path.lineTo(x,y);
                    canvas.drawPath(path,paint);

                }
                mx=x;
                my=y;
                break;
            case MotionEvent.ACTION_UP:


                break;


        }
        invalidate();
        return true;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }

}
