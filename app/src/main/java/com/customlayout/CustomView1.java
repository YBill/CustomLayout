package com.customlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by 卫彪 on 2016/8/29.
 */
public class CustomView1 extends TextView {

    private Paint paint;
    private Rect rect;
    private String text;

    public CustomView1(Context context) {
        super(context);
        init();
    }

    public CustomView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setTextSize(40);
        text = "Hello World";
        rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            paint.setTextSize(40);
            paint.getTextBounds(text, 0, text.length(), rect);
            float textWidth = rect.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            paint.setTextSize(40);
            paint.getTextBounds(text, 0, text.length(), rect);
            float textHeight = rect.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);


        paint.setColor(Color.RED);
        int x = (getWidth() - rect.width()) / 2;
        int y = (getHeight() + rect.height()) / 2;
        canvas.drawText(text, x, y, paint);
    }
}
