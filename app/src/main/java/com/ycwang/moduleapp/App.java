package com.ycwang.moduleapp;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author ycwang.
 * @date 2018-8-13.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){

            ARouter.openLog();
            ARouter.openDebug();

        }


        ARouter.init(this);
    }
}
