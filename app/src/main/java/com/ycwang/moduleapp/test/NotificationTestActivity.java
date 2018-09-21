package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ycwang.moduleapp.MainActivity;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-9-19.
 */
public class NotificationTestActivity extends Activity {

    NotificationManager manager;
    NotificationCompat.Builder mBuilder;

    public static void launch(Context context) {
        Intent intent = new Intent(context, NotificationTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        notificationProgressBar();


        TextView tx = findViewById(R.id.txw);
        tx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Updating notifications
                mBuilder.setContentTitle("更新后 Title")
                        .setContentText("更新后 Text")
                        .setSmallIcon(R.drawable.checkbox_no);
                manager.notify(10, mBuilder.build());
            }
        });

        TextView txw1 = findViewById(R.id.txw1);
        txw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Removing notifications
                manager.cancel(10);
//                manager.cancelAll();
            }
        });

    }


    private static final String KEY_TEXT_REPLY = "key_text_reply";

//    public void sendReply() {
//        RemoteInput remoteInput = new RemoteInput.Builder(KEY_TEXT_REPLY)
//                .setLabel("replyLabel")
//                .build();
//
//        Intent intent = new Intent(this, MainActivity.class);
//        PendingIntent pendingIntent = PendingIntent
//                .getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
//        Notification.Action action = new Notification.Action.Builder(R.drawable.checkbox_no,
//                "label", pendingIntent)
//                .addRemoteInput(remoteInput)
//                .build();
//
//        Intent intent2 = new Intent(this, AlertDialogActivity.class);
//        PendingIntent pendingIntent2 = PendingIntent
//                .getActivity(this, 2, intent2, PendingIntent.FLAG_UPDATE_CURRENT);
//        Notification.Action action2 = new Notification.Action.Builder(R.drawable.checkbox_yes,
//                "label2", pendingIntent2)
//                .addRemoteInput(remoteInput)
//                .build();
//
//
//        // Build the notification and add the action.
//        Notification newMessageNotification = new Notification.Builder(this)
//                .setSmallIcon(R.drawable.checkbox_disable)
//                .setContentTitle("title")
//                .setContentText("content")
//                .addAction(action)
//                .addAction(action2)
//                .build();
//
//
//// Issue the notification.
//        manager.notify(11, newMessageNotification);
//
//
//    }


    public void sendNotification2() {
        mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("更新前 Content Title")
                .setContentText("更新前 Content Text");

        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        inboxStyle.setBigContentTitle("Event tracker details:");
        inboxStyle.addLine("第一行，第一行，第一行，第一行，第一行，第一行，第一行")
                .addLine("第二行")
                .addLine("第三行")
                .addLine("第四行")
                .addLine("第五行");
        mBuilder.setStyle(inboxStyle);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(2, mBuilder.build());
    }


    public void sendNotification() {
        mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.checkbox_disable)
                .setContentTitle("更新前 Content Text")
                .setContentText("更新前 Content Text");

        Intent resultIntent = new Intent(this, BitmapActivty.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(BitmapActivty.class);
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        mBuilder.setContentIntent(pendingIntent);
        manager.notify(10, mBuilder.build());
    }


    public void sendNo() {
        Intent notifyIntent = new Intent(this, BitmapActivty.class);
        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent notifyPendingIntent = PendingIntent
                .getActivity(this, 0, notifyIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.checkbox_disable)
                .setContentTitle("更新前 Content Text")
                .setContentText("更新前 Content Text")
                .setContentIntent(notifyPendingIntent);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(11, builder.build());
    }

    int ID = 13;

    public void notificationProgressBar() {
        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Picture Download")
                .setContentText("Download in progress")
                .setSmallIcon(R.drawable.checkbox_yes);
        new Thread(new Runnable() {
            @Override
            public void run() {
                int incr;
                // Do the "lengthy" operation 20 times
                for (incr = 0; incr <= 100; incr += 5) {
                    // Sets the progress indicator to a max value, the
                    // current completion percentage, and "determinate"
                    // state
                    builder.setProgress(100, incr, false);
                    // Displays the progress bar for the first time.
                    notificationManager.notify(ID, builder.build());
                    // Sleeps the thread, simulating an operation
                    // that takes time
                    try {
                        // Sleep for 5 seconds
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Log.d("TAG", "sleep failure");
                    }
                }
                // When the loop is finished, updates the notification
                builder.setContentText("Download complete")
                        // Removes the progress bar
                        .setProgress(0, 0, false);
                notificationManager.notify(ID, builder.build());
            }
        }).start();
    }
}
