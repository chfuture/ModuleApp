package com.ycwang.moduleapp.test;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ycwang.
 * @date 2018-10-12.
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        Executor executor=new Executor() {
            @Override
            public void execute(@NonNull Runnable command) {

            }
        };

    }

}
