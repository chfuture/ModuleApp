package com.ycwang.moduleapp.fragment.view.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */

@Route(path = MainConstant.APP_MODULE_TO_OIL)
public class OilFragment extends Fragment {


    TextView txwFragment;

    View view;

    public static Fragment getInstance() {
        return new OilFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_oil, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txwFragment = view.findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment Oil");
    }

}
