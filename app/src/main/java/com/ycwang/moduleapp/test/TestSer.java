package com.ycwang.moduleapp.test;

import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author ycwang.
 * @date 2018-9-29.
 */
public class TestSer {

    public static void main(String[] args) {


        // 序列化过程
        MyUser user = new MyUser(13, "ycwang", "china");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("cache.txt"));
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // 反序列化操作
        MyUser user1 = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream("cache.txt"));
            user1 = (MyUser) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Log.e("ycwang",user1.toString());


    }

}
