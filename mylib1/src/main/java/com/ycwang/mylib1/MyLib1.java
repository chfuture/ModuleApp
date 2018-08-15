package com.ycwang.mylib1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.mylib1.permissioncheck.PermissionCheckActivity;


@Route(path = "/url/test")
public class MyLib1 extends AppCompatActivity {

    SingleService helloService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lib1);

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");

        TextView tv_2 = findViewById(R.id.tv_2);
        tv_2.setText("url:" + url + "   " + "title:" + title);

        tv_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                helloService = (SingleService) ARouter.getInstance().build("/single/service").navigation();
                helloService.sayHello("ycwang+=============");
            }
        });


        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PermissionCheckActivity.launch(MyLib1.this);
            }
        });
    }
}
