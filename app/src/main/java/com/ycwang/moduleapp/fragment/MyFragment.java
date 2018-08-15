package com.ycwang.moduleapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */

@Route(path = "/fragment/my")
public class MyFragment extends BaseFragment {

    TextView txwFragment;

    public static Fragment getInstance() {
        return new MyFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void afterActivityCreated(Bundle savedInstanceState) {
        txwFragment= (TextView) findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment My");
    }
}
