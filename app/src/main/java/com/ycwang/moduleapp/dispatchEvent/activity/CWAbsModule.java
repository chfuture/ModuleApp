package com.ycwang.moduleapp.dispatchEvent.activity;

import android.os.Bundle;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
public abstract class CWAbsModule {

    public abstract void init(CWModuleContext moduleContext, String extend);

    public abstract void onSaveInstanceState(Bundle outState);

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onStop();

    public abstract void onOrientationChanges(boolean isLandScape);

    public abstract void onDestroy();

}
