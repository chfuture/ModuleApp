package com.ycwang.mvpframe;

import android.app.Activity;

/**
 * @author ycwang.
 * @date 2018-8-17.
 */
public class BasePresenter<T extends IView> implements IPresenter {

    public T view;

    public BasePresenter(T view) {
        this.view = view;
    }

    Activity getActivity() {
        return view.getActivity();
    }

    /**
     * 用于判断当前view是否已经退出
     *
     * @return
     */
    public boolean isViewDetached() {
        return view == null || view.getActivity() == null || view.getActivity().isFinishing();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
