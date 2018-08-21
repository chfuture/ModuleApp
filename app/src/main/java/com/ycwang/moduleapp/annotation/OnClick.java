package com.ycwang.moduleapp.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ycwang.
 * @date 2018-8-20.
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@EventType(
        listenerType = View.OnClickListener.class,
        listenerSetter = "setOnClickListener",
        methodName = "onClick")
public @interface OnClick {

    int[] value();
}
