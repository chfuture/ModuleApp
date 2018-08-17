package com.ycwang.mvpframe;

import android.app.Activity;

/**
 * @author ycwang.
 * @date 2018-8-17.
 */
public interface IView<T> {

    Activity getActivity();

    /**
     * 请求开始
     */
    void onStart();

    /**
     * 请求结束
     */
    void onFinished();

    /**
     * 请求出错
     *
     * @param code    错误码
     * @param message 错误信息
     */
    void onError(int code, String message);

}
