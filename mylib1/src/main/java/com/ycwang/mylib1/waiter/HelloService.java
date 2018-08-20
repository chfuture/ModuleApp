package com.ycwang.mylib1.waiter;


import com.alibaba.android.arouter.facade.template.IProvider;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
public interface HelloService extends IProvider {
    void sayHello(String name);

}
