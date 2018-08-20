package com.ycwang.mylib1.webUrl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.mylib1.R;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */
// URL 中间跳转页
public class URLReceiveActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_receive);

        Uri url = getIntent().getData();
        ARouter.getInstance().build(url).navigation(this, new NavCallback() {
            @Override
            public void onArrival(Postcard postcard) {
                finish();
            }
        });


    }
}
