package com.ycwang.mylib1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.mylib1.R;
import com.ycwang.mylib1.permissioncheck.PermissionCheckActivity;
import com.ycwang.mylib1.waiter.HelloService;


@Route(path = "/url/test")
public class MyLib1Activity extends AppCompatActivity {


    @Autowired(name = "/single/service")
    HelloService helloService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lib1);

        ARouter.getInstance().inject(this);

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        TextView tv_2 = findViewById(R.id.tv_2);
        tv_2.setText("url:" + url + "   " + "title:" + title);

        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                helloService = (SingleService) ARouter.getInstance().build("/single/service").navigation();
                helloService.sayHello("ycwang+=============");
            }
        });


        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionCheckActivity.launch(MyLib1Activity.this);
            }
        });
    }
}
