package com.ycwang.moduleapp.dispatchEvent.activity.baseManager;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.util.ArrayMap;

import java.util.ArrayList;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ModuleManager {

    /**
     * 模块名字
     */
    public ArrayMap<String, ArrayList<Integer>> modules = new ArrayMap<>();

    protected ArrayMap<String, CWAbsModule> allModule = new ArrayMap<>();

    public void moduleConfig(ArrayMap<String, ArrayList<Integer>> modules) {
        this.modules = modules;
    }


    public CWAbsModule getModulesByName(String moduleName) {
        if (allModule != null && allModule.size() > 0) {
            return allModule.get(moduleName);
        }
        return null;
    }

    public void onResume() {
        for (CWAbsModule cwAbsModule : allModule.values()) {
            if (cwAbsModule != null) {
                cwAbsModule.onResume();
            }
        }
    }


    public void onPause() {
        for (CWAbsModule cwAbsModule : allModule.values()) {
            if (cwAbsModule != null) {
                cwAbsModule.onPause();
            }
        }
    }

    public void onStop() {
        for (CWAbsModule cwAbsModule : allModule.values()) {
            if (cwAbsModule != null) {
                cwAbsModule.onStop();
            }
        }
    }

    public void onOrientationChanges(boolean isLandScape) {
        for (CWAbsModule cwAbsModule : allModule.values()) {
            if (cwAbsModule != null) {
                cwAbsModule.onOrientationChanges(isLandScape);
            }
        }
    }

    public void onDestroy() {
        for (CWAbsModule cwAbsModule : allModule.values()) {
            if (cwAbsModule != null) {
                cwAbsModule.onDestroy();
            }
        }
    }


}
