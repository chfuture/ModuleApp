package com.ycwang.moduleapp.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-24.
 */
public class ServiceActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        findViewById(R.id.btn_start_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceActivity.this, ForegroundService.class);
                startService(intent);
//                bindService(new Intent(ServiceActivity.this, LocalService1.class),
//                        serviceConnection,
//                        Service.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btn_stop_service).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ServiceActivity.this, ForegroundService.class);
                stopService(intent);
//                unbindService(serviceConnection);
            }
        });


    }


    public ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e(MainConstant.TAG, "onServiceConnected++++" + componentName.getClassName());
            LocalService1.SimpleBinder binder = (LocalService1.SimpleBinder) iBinder;
            Log.e("ycwang", "78+65=" + binder.add(78, 65) + "");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e(MainConstant.TAG, "onServiceDisconnected++++" + componentName.getClassName());

        }
    };
}
