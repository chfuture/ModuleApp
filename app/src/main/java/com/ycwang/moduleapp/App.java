package com.ycwang.moduleapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * @author ycwang.
 * @date 2018-8-13.
 */
public class App extends Application {

    private static Activity activity;

    private static Context context;


    public static Activity getActivity() {
        return activity;
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                App.activity = activity;
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {
                App.activity = activity;
            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
}
