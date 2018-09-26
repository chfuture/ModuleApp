package com.ycwang.moduleapp.global;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * @author ycwang.
 * @date 2018-9-26.
 */
public class AbstractActivityLifeCircleCallBack implements Application.ActivityLifecycleCallbacks {


    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

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
}
