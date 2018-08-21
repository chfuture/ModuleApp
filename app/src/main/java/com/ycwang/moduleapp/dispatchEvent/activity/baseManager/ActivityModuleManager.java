package com.ycwang.moduleapp.dispatchEvent.activity.baseManager;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
public class ActivityModuleManager extends ModuleManager {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void initModules(Bundle saveInstanceState, Activity activity,
                            ArrayMap<String, ArrayList<Integer>> modules) {
        if (activity == null || modules == null) {
            return;
        }
        moduleConfig(modules);
        initModules(saveInstanceState,activity);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void initModules(Bundle instanceState, Activity activity) {
        if(modules==null){
            return;
        }

        for (String moduleName : modules.keySet()) {
            CWAbsModule module = CWModuleFactory.newModuleInstance(moduleName);
            if (module != null) {
                CWModuleContext moduleContext = new CWModuleContext();

                moduleContext.setContext(activity);
                moduleContext.setSaveInstanceState(instanceState);
                SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();
                ArrayList<Integer> mViewIds = modules.get(moduleName);
                if (mViewIds != null && mViewIds.size() > 0) {
                    for (int i = 0; i < mViewIds.size(); i++) {
                        viewGroups.put(i, (LinearLayout) activity.findViewById(mViewIds.get(i)));
                    }
                }
                moduleContext.setViewGroups(viewGroups);

                module.init(moduleContext, "");
                allModule.put(moduleName, module);
            }

        }
    }


}
