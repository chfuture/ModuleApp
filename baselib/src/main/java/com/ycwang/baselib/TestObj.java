package com.ycwang.baselib;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author ycwang.
 * @date 2018-8-13.
 */
public class TestObj implements Serializable {

    public String name;

    public String add;

    public int age;

    public TestObj(String name, String add, int age) {
        this.name = name;
        this.add = add;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
