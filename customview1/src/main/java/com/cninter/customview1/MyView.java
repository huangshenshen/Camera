package com.cninter.customview1;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ${jacksen-hss} on 2016/6/30 0030.
 */
public class MyView extends View {
    String txt_values;
    Drawable image_values;

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.myview_attrs);
        txt_values = typedArray.getString(R.styleable.myview_attrs_txt);
        image_values = typedArray.getDrawable(R.styleable.myview_attrs_image);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        //需要把drawable对象转成Bitmap
        BitmapDrawable bitmapDrawable  = (BitmapDrawable) image_values;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        canvas.drawBitmap(bitmap,0,0,paint);
        canvas.drawText(txt_values,bitmap.getWidth(),(bitmap.getHeight()+paint.getTextSize())/2,paint);

    }
}
