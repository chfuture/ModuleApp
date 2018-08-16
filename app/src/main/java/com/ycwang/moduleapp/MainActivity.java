package com.ycwang.moduleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.baselib.TestObj;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/url/test")
                        .withString("url", "来自main的url")
                        .withString("title", "来自main的title").navigation();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/hello/mylib2")
                        .withString("url", "牛逼好点撒")
                        .withString("title", "答复哈咯")
                        .navigation();
            }
        });

        findViewById(R.id.btn_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/test/myliba")
                        .withSerializable("obj", new TestObj("ycwang", "河北", 19))
//                        .greenChannel() // 无视拦截器
                        .navigation(MainActivity.this, 666);
            }
        });

        findViewById(R.id.btn_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/fragment/main").navigation();
            }
        });



    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 666:

                if (data != null) {
                    Log.e("ycwang", String.valueOf(resultCode));
                    Log.e("ycwang", data.getStringExtra("ycwang"));
                }


                break;
            default:
                break;
        }
    }

}
