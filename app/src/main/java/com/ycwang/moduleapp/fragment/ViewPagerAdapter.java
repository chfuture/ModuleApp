package com.ycwang.moduleapp.fragment;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * @author ycwang.
 * @date 2018-8-14.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setList(Fragment[] fragments) {
        if (fragments != null) {
            this.fragments = fragments;
        }
    }



    @Override
    public Fragment getItem(int i) {
        return fragments[i];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
