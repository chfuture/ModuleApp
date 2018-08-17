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
                        .withString("url", "来自MainActivity的URL")
                        .withString("title", "来自MainActivity的TITLE").navigation();
            }
        });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/hello/mylib2")
                        .withString("url", "来自MainActivity的URL")
                        .withString("title", "来自MainActivity的TITLE")
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
                ARouter.getInstance().build("/fragment/main").navigation(MainActivity.this,
                        new NavCallback() {

                            @Override
                            public void onFound(Postcard postcard) {
                                Log.e("ycwang", "onFound:找到了");
                            }

                            @Override
                            public void onArrival(Postcard postcard) {
                                Log.e("ycwang", "onArrival:跳转结束");
                            }

                            @Override
                            public void onLost(Postcard postcard) {
                                Log.e("ycwang", "onLost:找不到了");
                            }

                            @Override
                            public void onInterrupt(Postcard postcard) {
                                Log.e("ycwang", "onInterrupt:被拦截了");
                            }


                        });
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
