package com.example.mvpdagger;

import android.content.Context;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class MyDefineView extends View {
    int mcolor;
    int text_size;
    public MyDefineView(Context context) {
        super(context,null);
    }

    public MyDefineView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public MyDefineView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyDefine);
        mcolor = array.getColor(R.styleable.MyDefine_ground, Color.BLACK);
        text_size = array.getInteger(R.styleable.MyDefine_text_size, 24);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("MyDefineView","widthMeasureSpec = "+widthMeasureSpec
                + "   heightMeasureSpec = "+heightMeasureSpec);
        /** 遍历每个子View */
//        for(int i = 0 ; i < getChildCount() ; i++){
//            View child = getChildAt(i);
//            //调用子View的onMeasure，设置他们的大小,
//            child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
//        }
//        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
