package com.ycwang.mylib1.webUrl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.mylib1.R;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */

@Route(path = "/web/NoCanReceiveURLActivity")
public class NoCanReceiveURLActivity extends Activity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_receive);


        TextView textView = findViewById(R.id.web_receive);
        textView.setText("Web传递  无参");
    }
}
