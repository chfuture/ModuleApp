package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ycwang.moduleapp.R;

import java.io.File;

/**
 * @author ycwang.
 * @date 2018-8-31.
 */
public class IntentActivity extends Activity {

    Button button;

    public static void launch(Context context) {
        Intent intent = new Intent(context, IntentActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        button = findViewById(R.id.btn_test_intent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMap(Uri.parse("geo:36.500279,114.709705?z=11"));
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case 666:
                if (data != null) {
                    Log.e("ycwang", String.valueOf(resultCode));
                    Log.e("ycwang", data.getStringExtra("ycwang"));
                }
                break;

            case 1001:
                Bitmap thumbnail = data.getParcelableExtra("data");
                Log.e("ycwang", thumbnail.toString());
                break;

            case 1002:
            case 1003:
                Uri contactUri = data.getData();
                Log.e("ycwang", contactUri.toString());
                break;

            default:
                break;
        }
    }


//    ACTION_SETTINGS
//            ACTION_WIRELESS_SETTINGS
//    ACTION_AIRPLANE_MODE_SETTINGS
//            ACTION_WIFI_SETTINGS
//    ACTION_APN_SETTINGS
//            ACTION_BLUETOOTH_SETTINGS
//    ACTION_DATE_SETTINGS
//            ACTION_LOCALE_SETTINGS
//    ACTION_INPUT_METHOD_SETTINGS
//            ACTION_DISPLAY_SETTINGS
//    ACTION_SECURITY_SETTINGS
//            ACTION_LOCATION_SOURCE_SETTINGS
//    ACTION_INTERNAL_STORAGE_SETTINGS
//            ACTION_MEMORY_CARD_SETTINGS
//
//    public void openWifiSettings() {
//        Intent intent = new Intent(Intent.);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }

    /**
     * 显示经纬度
     *
     * @param geoLocation
     */
    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * 选择一张图片
     */
    public void selectImage() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
        startActivityForResult(intent, 1003);
    }


    /**
     * 选择联系人
     */
    public void selectContract() {
        Intent intent = new Intent(Intent.ACTION_PICK)
                .setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1002);
        }
    }


    public void capturePhotoVideo() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1001);
        }
    }

    /**
     * 设置闹钟
     */
    public void startAlarm() {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "闹钟测试")
                .putExtra(AlarmClock.EXTRA_MINUTES, 1);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * 设置倒计时
     */
    public void startTimer() {
        Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "测试倒计时")
                .putExtra(AlarmClock.EXTRA_LENGTH, 10)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, true);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * 显示闹钟
     */
    public void showAllAlarm() {
        Intent intent = new Intent(AlarmClock.ACTION_SHOW_ALARMS);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    /**
     * 日历提醒
     */
    public void addCalenderEvent() {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, "ycwang")
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "hello")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, "2019-10-20")
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, "2019-10-30");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    public void capturePicOrVideo() {
        File file = getFile(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "avatar", "avatar.jpg");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                .putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1001);
        }
    }


    public static File getFile(final File rootPath, final String subPath, final String fileName) {
        if (rootPath == null) {
            throw new IllegalArgumentException();
        } else if (rootPath.isFile()) {
            return rootPath;
        } else {
            final File dir = TextUtils.isEmpty(subPath) ? rootPath : new File(rootPath, subPath);
            if (TextUtils.isEmpty(fileName)) {
                if (dir.exists()) {
                    return dir;
                } else {
                    return dir.mkdirs() ? dir : null;
                }
            } else {
                if (dir.exists()) {
                    return new File(dir, fileName);
                } else {
                    return dir.mkdirs() ? new File(dir, fileName) : null;
                }
            }
        }
    }


    public void capturePhoto() {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 1001);
        }
    }


}
