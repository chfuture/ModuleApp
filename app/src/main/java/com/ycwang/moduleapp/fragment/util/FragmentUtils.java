package com.ycwang.moduleapp.fragment.util;

import android.support.v4.app.Fragment;

import com.ycwang.moduleapp.global.MainPageConfig;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
public class FragmentUtils {

    public static Fragment createFragment(Integer tag) {
        try {
            String name = MainPageConfig.PATH + MainPageConfig.FRAGMENT_NAME[tag];
            Fragment fragment = (Fragment) Class.forName(name).newInstance();
            MainPageConfig.FRAGMENTS[tag] = fragment;
            return fragment;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
