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

@Route(path = "/fragment/oil")
public class OilFragment extends BaseFragment {


    TextView txwFragment;

    public static Fragment getInstance() {
        return new OilFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_oil;
    }

    @Override
    protected void afterActivityCreated(Bundle savedInstanceState) {
        txwFragment= (TextView) findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment Oil");
    }
}
