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

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */

@Route(path = MainConstant.APP_MODULE_TO_MY)
public class MyFragment extends Fragment {

    TextView txwFragment;

    View view;


    private Activity activity;

    public static Fragment getInstance() {
        return new MyFragment();
    }

    //Fragment和Activity相关联时调用。可以通过该方法获取Activity引用，还可以通过getArguments()获取参数
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (Activity) context;
    }

    //Fragment被创建时调用。
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //创建Fragment的布局。
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;
    }

    //当Activity完成onCreate()时调用。
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txwFragment = view.findViewById(R.id.txw_fragment);
        txwFragment.setText("Fragment My");
    }

    //当Fragment可见时调用。
    @Override
    public void onStart() {
        super.onStart();
    }

    //当Fragment可见且可交互时调用。
    @Override
    public void onResume() {
        super.onResume();
    }

    //当Fragment不可交互但可见时调用。
    @Override
    public void onPause() {
        super.onPause();
    }

    //当Fragment不可见时调用。
    @Override
    public void onStop() {
        super.onStop();
    }


    //当Fragment的UI从视图结构中移除时调用。
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //销毁Fragment时调用。
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //当Fragment和Activity解除关联时调用。
    @Override
    public void onDetach() {
        super.onDetach();
    }



    //只有onCreateView()在重写时不用写super方法，其他都需要。
}
