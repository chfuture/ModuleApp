package com.ycwang.moduleapp;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
// 拦截器
@Interceptor(priority = 7, name = "aasj")
public class TestIntecepter implements IInterceptor {

    private Context mContext;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        String path = postcard.getPath();
        // 拦截 /test/myliba 的跳转
        if (TextUtils.equals("/test/myliba", path)) {
            Log.e("ycwang", "您需要进行登录才能使用该功能");
        } else {
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }
}
