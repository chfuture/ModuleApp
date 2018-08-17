package com.ycwang.moduleapp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
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

    private Fragment[] fragments = new Fragment[4];

    private Fragment mCurrentFragment;

    private int currentIndex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        // ARouter路由获取Fragment
        Fragment fragment;

        Bundle bundle = new Bundle();
        bundle.putString("ycwang", "======");
        fragment = (Fragment) ARouter.getInstance().build("/fragment/home")
                // 向Fragment中传递参数
                .withBundle("key", bundle).navigation();
        fragments[0] = fragment;
        fragment = (Fragment) ARouter.getInstance().build("/fragment/discovery").navigation();
        fragments[1] = fragment;
        fragment = (Fragment) ARouter.getInstance().build("/fragment/my").navigation();
        fragments[2] = fragment;
        fragment = (Fragment) ARouter.getInstance().build("/fragment/oil").navigation();
        fragments[3] = fragment;


        // 反射获取Fragment
//        fragments[0] = PagerConfig.createFragment(0);
//        fragments[1] = PagerConfig.createFragment(1);
//        fragments[2] = PagerConfig.createFragment(2);
//        fragments[3] = PagerConfig.createFragment(3);


        switchTab(0);

        findViewById(R.id.btn_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTab(0);
            }
        });
        findViewById(R.id.btn_discovery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTab(1);
            }
        });
        findViewById(R.id.btn_my).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTab(2);
            }
        });
        findViewById(R.id.btn_oil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchTab(3);
            }
        });
    }


    private void switchTab(int index) {
        currentIndex = index;
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (null != mCurrentFragment) {
            transaction.hide(mCurrentFragment);
        }
        Fragment fragment = getSupportFragmentManager()
                .findFragmentByTag(fragments[currentIndex].getClass().getName());
        if (null == fragment) {
            fragment = fragments[index];
        }
        mCurrentFragment = fragment;
        if (!fragment.isAdded()) {
            transaction.add(R.id.frame_content, fragment, fragment.getClass().getName());
        } else {
            transaction.show(fragment);
        }
        transaction.addToBackStack("name" + PagerConfig.FRAGMENT_NAME[currentIndex]);
        transaction.commit();
    }


}
