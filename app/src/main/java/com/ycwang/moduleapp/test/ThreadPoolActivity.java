package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ycwang.moduleapp.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ycwang.
 * @date 2018-10-15.
 */
public class ThreadPoolActivity extends Activity {


    public static void launch(Context context) {
        Intent intent = new Intent(context, ThreadPoolActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_test);


        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            MyThread myThread = new MyThread(i);
            service.execute(myThread);
        }
    }


    class MyThread implements Runnable {

        int threadNum;

        public MyThread(int threadNum) {
            this.threadNum = threadNum;
        }

        @Override
        public void run() {
            Log.e("打印信息", "等待中。。。执行第" + threadNum + "号线程");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e("打印信息", "完成第" + threadNum + "号线程");
        }
    }
}
