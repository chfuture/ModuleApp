package com.ycwang.mylib1.waiter;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */

@Route(path = "/single/service",name = "singleservice")
public class SingleService implements HelloService{

    private Context mContext;

    @Override
    public void sayHello(String name) {
        Toast.makeText(mContext, "Hello " + name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.mContext=context;
    }
}
