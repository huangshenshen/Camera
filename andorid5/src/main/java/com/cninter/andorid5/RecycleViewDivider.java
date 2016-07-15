package com.cninter.andorid5;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by ${jacksen-hss} on 2016/7/14 0014.
 */
public class RecycleViewDivider extends RecyclerView.ItemDecoration {
    Paint paint;

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
       // super.onDraw(c, parent, state);
        final int left = 0;
        final int right = parent.getWidth();
        //确定数据条数
        final int itemcount=parent.getChildCount();
        //得到画笔
        if (paint==null){
            paint = new Paint();
            paint.setColor(Color.RED);

        }
        if (itemcount>0){
            for (int i=0;i<itemcount;i++){
                View itemview = parent.getChildAt(i);
                c.drawLine(left,itemview.getBottom(),right,itemview.getBottom(),paint);
            }
        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }
}
