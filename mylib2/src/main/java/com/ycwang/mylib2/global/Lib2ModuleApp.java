package com.ycwang.mylib2.global;

import android.app.Application;
import android.util.Log;

import com.ycwang.moduleApp.ModuleImpl;

/**
 * @author ycwang.
 * @date 2018-8-21.
 */
public class Lib2ModuleApp implements ModuleImpl {
    @Override
    public void onLoad(Application application) {
        for (int i = 0; i < 5; i++) {
            Log.e("ycwang", "Lib2ModuleApp" + i);
        }
    }
}
