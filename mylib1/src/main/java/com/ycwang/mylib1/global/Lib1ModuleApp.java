package com.ycwang.mylib1.global;

import android.app.Application;
import android.util.Log;

import com.ycwang.moduleApp.ModuleImpl;

/**
 *  初始化 用发如Application
 * @author ycwang.
 * @date 2018-8-21.
 */
public class Lib1ModuleApp implements ModuleImpl {
    @Override
    public void onLoad(Application application) {
        for (int i = 0; i < 5; i++) {
            Log.e("ycwang", "Lib1ModuleApp" + i);
        }
    }
}
