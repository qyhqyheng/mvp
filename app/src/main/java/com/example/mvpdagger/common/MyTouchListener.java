package com.example.mvpdagger.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.constraint.ConstraintLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;


public class MyTouchListener implements View.OnTouchListener{
    public float lastX;
    public float lastY;
     // 1、event.getRowX（）：触摸点相对于屏幕原点的x坐标
    //  2、event.getX（）：   触摸点相对于其所在组件原点的x坐标
    //  2、view.getX（）：   触摸点相对自身组件的x距离
    //  2、view.getLeft（）：触摸点相对与父控件的左边距的距离
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction() & event.ACTION_MASK){
            case MotionEvent.ACTION_DOWN:
                lastX = event.getRawX();
                lastY = event.getRawY();
                Log.e("TouchListener","MainActivity---ACTION_DOWN---lastX = "+lastX+"   lastY = "+lastY);
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = event.getRawX() - lastX;
                float dy = event.getRawY() - lastY;
                float nextY = v.getY() + dy;
                float nextX = v.getX() + dx;
                if(nextX>=((ViewGroup) v.getParent()).getWidth()-v.getWidth()){     //右侧
                    nextX = ((ViewGroup) v.getParent()).getWidth()-v.getWidth();
                }
                if(nextX<=0){                //左侧
                    nextX=0;
                }
                if(nextY>=((ViewGroup) v.getParent()).getHeight()-v.getHeight()){
                    nextY = ((ViewGroup) v.getParent()).getHeight()-v.getHeight();
                }
                if(nextY<=0){
                    nextY=0;
                }

                ObjectAnimator y = ObjectAnimator.ofFloat(v, "y", v.getY(), nextY);
                ObjectAnimator x = ObjectAnimator.ofFloat(v, "x", v.getX(), nextX);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(x, y);
                animatorSet.setDuration(0);
                animatorSet.start();

                lastX = event.getRawX();    //记录最后一次移动的位置
                lastY = event.getRawY();
                Log.e("TouchListener","MainActivity---ACTION_MOVE---lastX = "+lastX+"   lastY = "+lastY);
                break;
        }
        return false;
    }
}
