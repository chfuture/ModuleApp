package com.ycwang.moduleapp.fragment;

import android.support.v4.app.Fragment;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
public class PagerConfig {


    public static String[] FRAGMENT_NAME = new String[]
            {"HomeFragment", "DiscoveryFragment", "MyFragment", "OilFragment"};

    public static String PATH = "com.ycwang.moduleapp.fragment.";

    public static Fragment[] FRAGMENTS = new Fragment[4];


    public static Fragment createFragment(Integer tag) {
        try {
            String name = PATH + FRAGMENT_NAME[tag];
            Fragment fragment = (Fragment) Class.forName(name).newInstance();
            FRAGMENTS[tag] = fragment;
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
