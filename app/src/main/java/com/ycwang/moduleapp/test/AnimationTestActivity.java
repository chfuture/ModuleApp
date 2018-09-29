package com.ycwang.moduleapp.test;

import android.animation.ArgbEvaluator;
import android.animation.FloatEvaluator;
import android.animation.IntEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ycwang.moduleapp.R;
import com.ycwang.moduleapp.global.App;

/**
 * @author ycwang.
 * @date 2018-9-28.
 */
public class AnimationTestActivity extends Activity {

    TextView txt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);

        txt = findViewById(R.id.txt);
        txt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(final View view) {

// 宽度在5秒内由0变为500px
//                ViewWrapper viewWrapper = new ViewWrapper(txt);
//                ObjectAnimator animator = ObjectAnimator.ofInt(viewWrapper, "width", 0, 500);
//                animator.setDuration(5000);
//                animator.start();


// 宽度在5秒内由0变为500px
//                ValueAnimator animator = ValueAnimator.ofInt(1, 100);
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    IntEvaluator evaluator = new IntEvaluator();
//
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        int currentValue = (int) valueAnimator.getAnimatedValue();
//                        Log.e("ycwang", "currentValue:" + currentValue);
//                        float fraction = valueAnimator.getAnimatedFraction();
//                        Log.e("ycwang", "fraction:" + fraction);
//                        view.getLayoutParams().width = evaluator.evaluate(fraction, 0, 500);
//                        view.requestLayout();
//                    }
//                });
//                animator.setDuration(5000);
//                animator.start();

// 背景颜色在5秒内由白色变为红色
//                ObjectAnimator animator = ObjectAnimator.ofArgb(txt, "backgroundColor", 0xfff10f0f, 0xff0f94f1, 0xffeaf804, 0xfff92a0f);
//                animator.setDuration(5000);
//                animator.setEvaluator(new ArgbEvaluator());
//                animator.start();

// 背景颜色在5秒内由白色变为红色
//                ValueAnimator animator = ValueAnimator.ofInt(0, 100);
//                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
//
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                        int currentValue = (int) valueAnimator.getAnimatedValue();
//                        float fraction = valueAnimator.getAnimatedFraction();
//                        txt.setBackgroundColor((Integer) argbEvaluator.evaluate(fraction, 0xffffffff, 0xffff4400));
//                    }
//                });
//                animator.setDuration(5000);
//                animator.start();

// Floating Button
                Button button = new Button(App.getTopActivity());
                button.setText("Button");
                final WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        0,
                        0,
                        PixelFormat.TRANSPARENT);
                params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
//                params.gravity = Gravity.LEFT | Gravity.TOP;
                params.x = 100;
                params.y = 300;

                final WindowManager windowManager = App.getTopActivity().getWindowManager();
                button.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        int rawX = (int) motionEvent.getRawX();
                        int rawY = (int) motionEvent.getRawY();
                        switch (motionEvent.getAction()) {
                            case MotionEvent.ACTION_MOVE:
                                params.x = rawX;
                                params.y = rawY;
                                windowManager.updateViewLayout(view, params);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
                windowManager.addView(button, params);
            }
        });


        // 测试
        String s = "abcde你好";
        EditText editText = findViewById(R.id.edx);
        editText.setText(s);
        editText.setSelection(s.length());


    }


    public class ViewWrapper {

        View view;

        public ViewWrapper(View view) {
            this.view = view;
        }

        public int getWidth() {
            return view.getLayoutParams().width;
        }

        public void setWidth(int width) {
            view.getLayoutParams().width = width;
            view.requestLayout();
        }


        public int getArgb() {
            return view.getDrawingCacheBackgroundColor();
        }

        public void setArgb(int argb) {
            view.setBackgroundColor(argb);
//            view.invalidate();
        }
    }

}
