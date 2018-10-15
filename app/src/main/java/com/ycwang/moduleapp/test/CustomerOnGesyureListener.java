package com.ycwang.moduleapp.test;

import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * @author ycwang.
 * @date 2018-10-10.
 */
public class CustomerOnGesyureListener implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {
    @Override
    public boolean onDown(MotionEvent e) {
        // 手指刚刚触摸屏幕的一瞬间，由1个ActionDown事件组成
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        ///单击事件
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        /// 拖动行为 一个ActionDown 多个ActionMove
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        /// 长按

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        /// 快速滑动
        return false;
    }


    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        // 严格的单击
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        /// 双击
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }
}
