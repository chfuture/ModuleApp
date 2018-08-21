package com.ycwang.mylib1.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ycwang.baselib.TestObj;
import com.ycwang.mylib1.R;

/**
 * @author ycwang.
 * @date 2018-8-13.
 */

@Route(path = "/test/myliba")
public class MyLibAActivity extends Activity {

    @Autowired(name = "obj")
    public TestObj obj;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lib_a);

        ARouter.getInstance().inject(this);


        TextView tv_3 = findViewById(R.id.tv_3);
        tv_3.setText("name:" + obj.name + "   " + "add:" + obj.add + "   " + "age:" + obj.age);





        tv_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("ycwang","ycwang+++++");
                setResult(666,intent);
                finish();
            }
        });
    }
}
