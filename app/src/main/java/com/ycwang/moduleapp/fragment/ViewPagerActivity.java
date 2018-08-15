package com.ycwang.moduleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.moduleapp.R;


/**
 * @author ycwang.
 * @date 2018-8-14.
 */
@Route(path = "/fragment/main")
public class ViewPagerActivity extends FragmentActivity {

    FragmentManager fragmentManager;

    FragmentTransaction transaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        fragmentManager = getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        Fragment fragment;

//        fragment = (Fragment) ARouter.getInstance().build("/fragment/home").navigation();
        fragment = HomeFragment.getInstance();
        fragments[0] = fragment;

//        fragment = (Fragment) ARouter.getInstance().build("/fragment/discovery").navigation();
        fragment = DiscoveryFragment.getInstance();
        fragments[1] = fragment;


//        fragment = (Fragment) ARouter.getInstance().build("/fragment/my").navigation();
        fragment = MyFragment.getInstance();
        fragments[2] = fragment;

//        fragment = (Fragment) ARouter.getInstance().build("/fragment/oil").navigation();
        fragment = OilFragment.getInstance();
        fragments[3] = fragment;

//        add(transaction);
        swicth(0);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swicth(0);
            }
        });
        findViewById(R.id.btn_discovery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swicth(1);
            }
        });
        findViewById(R.id.btn_my).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swicth(2);
            }
        });
        findViewById(R.id.btn_oil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swicth(3);
            }
        });
    }


    Fragment[] fragments = new Fragment[4];


    public void add(FragmentTransaction transaction){
        for (Fragment fragment : fragments) {
            transaction.add(R.id.frame_content, fragment);
        }
    }

//    public void swicth(int tag,FragmentTransaction transaction) {
//
//        transaction=fragmentManager.beginTransaction();
//        for (Fragment fragment1 : fragments) {
//            if (fragment1 != null) {
//                transaction.hide(fragment1);
//            }
//        }
//        transaction.show(fragments[tag]);
//        transaction.commitAllowingStateLoss();
//    }



    Fragment mCurrentFrgment;
    int currentIndex;

    private void swicth(int index) {
        currentIndex = index;

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        if (null != mCurrentFrgment) {
            ft.hide(mCurrentFrgment);
        }
        //先根据Tag从FragmentTransaction事物获取之前添加的Fragment
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragments[currentIndex].getClass().getName());

        if (null == fragment) {
            //如fragment为空，则之前未添加此Fragment。便从集合中取出
            fragment = fragments[index];
        }
        mCurrentFrgment = fragment;

        if (!fragment.isAdded()) {
            ft.add(R.id.frame_content, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commit();
    }


}
