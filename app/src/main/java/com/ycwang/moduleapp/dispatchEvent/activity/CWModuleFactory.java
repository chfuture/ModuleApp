package com.ycwang.moduleapp.dispatchEvent.activity;

import android.text.TextUtils;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
public class CWModuleFactory {

    public static CWAbsModule newModuleInstance(String name) {
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        try {
            Class<? extends CWAbsModule> moduleClazz = (Class<? extends CWAbsModule>) Class.forName(name);
            if (moduleClazz != null) {
                return moduleClazz.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}
