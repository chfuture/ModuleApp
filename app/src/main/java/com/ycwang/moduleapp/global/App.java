package com.ycwang.moduleapp.global;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

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

        // ARouter 路由初始化
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);


        // ********************************* 获取顶部Activity start*********************************
        registerActivityLifecycleCallbacks(new AbstractActivityLifeCircleCallBack() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                App.activity = activity;
            }

            @Override
            public void onActivityResumed(Activity activity) {
                App.activity = activity;
            }
        });
        // ********************************* 获取顶部Activity start*********************************


        loadModuleApp();


        // app 处于前台后台
        listenForForeground();
        listenForScreenTurningOff();
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


    // **************************** App 前后台切换 start ******************************

    private boolean isBackground;

    private void listenForForeground() {
        registerActivityLifecycleCallbacks(new AbstractActivityLifeCircleCallBack() {

            @Override
            public void onActivityResumed(Activity activity) {
                if (isBackground) {
                    isBackground = false;
                    notifyForeground();
                }
            }
        });
    }

    private void listenForScreenTurningOff() {
        IntentFilter screenStateFilter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                isBackground = true;
                notifyBackground();
            }
        }, screenStateFilter);
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            isBackground = true;
            notifyBackground();
        }
    }

    private void notifyForeground() {
        Log.e("ycwang", "Foreground----isBackground" + isBackground);
        // This is where you can notify listeners, handle session tracking, etc
    }

    private void notifyBackground() {
        Log.e("ycwang", "Background----isBackground" + isBackground);
        // This is where you can notify listeners, handle session tracking, etc
    }

    public boolean isBackground() {
        return isBackground;
    }

    // **************************** App 前后台切换 start ******************************


}
