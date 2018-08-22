package com.ycwang.moduleapp.fragment.view.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
@Route(path = MainConstant.APP_MODULE_TO_HOME)
public class HomeFragment extends Fragment {

    TextView txwFragment;

    View view;

    Activity activity;

    String params;


    @Autowired(name = "key")
    public Bundle bundle;


    public static Fragment getInstance() {
        return new HomeFragment();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        ARouter.getInstance().inject(this);

        activity = (Activity) context;
        params = bundle.getString("ycwang");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txwFragment = view.findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment Home" + "+++++" + params);
    }


}
