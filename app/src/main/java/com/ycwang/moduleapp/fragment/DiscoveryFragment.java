package com.ycwang.moduleapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.moduleapp.R;

import butterknife.BindView;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */

@Route(path = "/fragment/discovery")
public class DiscoveryFragment extends BaseFragment {
    TextView txwFragment;


    public static Fragment getInstance() {
        return new DiscoveryFragment();
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_discovery;
    }

    @Override
    protected void afterActivityCreated(Bundle savedInstanceState) {
        txwFragment= (TextView) findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment Discovery");
    }
}
