package com.ycwang.moduleapp.test;

import java.io.Serializable;

/**
 * @author ycwang.
 * @date 2018-9-29.
 */
public class MyUser implements Serializable {

    public static long serialVersionUID = 1L;

    public int age;

    public String name;

    public String address;

    public MyUser(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
