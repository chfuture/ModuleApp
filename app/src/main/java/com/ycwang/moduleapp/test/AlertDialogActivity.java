package com.ycwang.moduleapp.test;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * @author ycwang.
 * @date 2018-9-19.
 */
public class AlertDialogActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("标题");
        builder.setMessage("内容");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "取消 :" + i, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "确认 :" + i, Toast.LENGTH_SHORT).show();
            }
        });

        String[] strings = new String[]{"1", "2", "3", "4"};
        builder.setItems(strings, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "点击的item :" + i, Toast.LENGTH_SHORT).show();
            }
        });

        Dialog dialog = builder.create();

        dialog.show();
    }
}
