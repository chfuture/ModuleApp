package com.ycwang.mylib1.webUrl;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.global.MainConstant;
import com.ycwang.mylib1.R;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */
// web 跳转到本地页面 有参数
@Route(path = MainConstant.WEB_MODULE_WITH_DATA)
public class HasCanReceiveURLActivity extends Activity {

    TextView textView;

    @Autowired
    String name;

    @Autowired
    int age;

    @Autowired
    boolean boy;

    @Autowired
    int high;

    @Autowired
    String obj;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_url_receive);
        ARouter.getInstance().inject(this);

        textView = findViewById(R.id.web_receive);


        //解析参数
        Bundle bundle = getIntent().getExtras();
        String name1 = bundle.getString("name");

        textView.setText("参数是： " + "name: " + name + "  age: " + age
                + " boy: " + boy + " name1: " + name1 + " obj: " + obj.toString());
    }
}
