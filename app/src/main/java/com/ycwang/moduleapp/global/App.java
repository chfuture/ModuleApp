package com.ycwang.moduleapp.global;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.moduleApp.ModuleImpl;
import com.ycwang.moduleapp.BuildConfig;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ycwang.
 * @date 2018-8-13.
 */
public class App extends Application {

    private static Activity activity;

    private static Context context;


    /**
     * 获取顶部Activity
     *
     * @return
     */
    public static Activity getTopActivity() {
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

        loadModuleApp();
    }


    public void loadModuleApp() {
        for (String s : MainPageConfig.MODULE_APP) {
            try {
                Class clazz = Class.forName(s);
                Object imp = clazz.newInstance();
                if (imp instanceof ModuleImpl) {
                    Method m = clazz.getDeclaredMethod("onLoad", Application.class);
                    m.invoke(imp, this);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }
}
