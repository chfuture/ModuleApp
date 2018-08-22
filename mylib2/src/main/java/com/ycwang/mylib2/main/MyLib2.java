package com.ycwang.mylib2.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.global.MainConstant;
import com.ycwang.mylib2.R;


@Route(path = MainConstant.MYLIB2_MODULE_MAIN)
public class MyLib2 extends AppCompatActivity {

    @Autowired
    public String url;

    @Autowired(name = "title")
    public String hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lib2);

        ARouter.getInstance().inject(this);

//        String url = getIntent().getStringExtra("url");
//        String title = getIntent().getStringExtra("title");

        TextView tv = findViewById(R.id.tv_1);
        tv.setText("url:" + url + "      " + "title:" + hello);
    }
}
