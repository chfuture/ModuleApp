package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-9-11.
 */
public class MessagerActivity extends Activity {

    Messenger mService = null;

    boolean mBound;

    Button btn;


    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mService = new Messenger(iBinder);
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mService = null;
            mBound = false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messager);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mBound) {
                    return;
                }
                // Create and send a message to the service, using a supported 'what' value
                Message msg = Message.obtain(null, MessageService.MSG_SAY_HELLO, 0, 0);
                try {
                    mService.send(msg);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, MessageService.class), serviceConnection,
                Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mBound) {
            unbindService(serviceConnection);
            mBound = false;
        }
    }
}
