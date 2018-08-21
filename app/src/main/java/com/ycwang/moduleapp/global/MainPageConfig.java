package com.ycwang.moduleapp.global;

import android.support.v4.app.Fragment;

/**
 * @author ycwang.
 * @date 2018-8-21.
 */
public class MainPageConfig {

    /**
     * Module Application 模块化application
     */
    private static final String MODULE_LIB1_APP = "com.ycwang.mylib1.global.Lib1ModuleApp";
    private static final String MODULE_LIB2_APP = "com.ycwang.mylib2.global.Lib2ModuleApp";
    public static final String[] MODULE_APP = new String[]{MODULE_LIB1_APP, MODULE_LIB2_APP};

    /**
     * Fragment
     */
    public static String[] FRAGMENT_NAME = new String[]
            {"HomeFragment", "DiscoveryFragment", "MyFragment", "OilFragment"};
    public static String PATH = "com.ycwang.moduleapp.fragment.";
    public static Fragment[] FRAGMENTS = new Fragment[4];

    /**
     * Activity 事件分发
     */
    public static final String MODULE_PAGE_NAME =
            "com.ycwang.moduleapp.dispatchEvent.activity.view.widget.ModulePageName";
    public static final String MODULE_PAGE_BODY =
            "com.ycwang.moduleapp.dispatchEvent.activity.view.widget.ModulePageBody";

}
