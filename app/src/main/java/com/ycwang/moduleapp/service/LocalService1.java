package com.ycwang.moduleapp.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author ycwang.
 * @date 2018-8-24.
 */
public class LocalService1 extends Service {

    public class SimpleBinder extends Binder {

        public LocalService1 getService() {
            return LocalService1.this;
        }

        public int add(int a, int b) {
            return a + b;
        }
    }


    private SimpleBinder binder;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("ycwang", "onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("ycwang", "onCreate");
        binder=new SimpleBinder();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("ycwang", "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.e("ycwang", "onDestroy");
        super.onDestroy();
    }


}
