package com.ycwang.mylib1.permissioncheck;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.ycwang.mylib1.R;

import java.security.Permission;
import java.security.Permissions;
import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-15.
 */
public class PermissionCheckActivity extends Activity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, PermissionCheckActivity.class);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_check);

        findViewById(R.id.btn_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndPermission.with(PermissionCheckActivity.this)
                        .runtime()
                        .permission(com.yanzhenjie.permission.Permission.Group.CAMERA)
                        .onGranted(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                Log.e("ycwang", "LOCATION Granted");
                            }
                        })
                        .rationale(new Rationale<List<String>>() {
                            @Override
                            public void showRationale(Context context, List<String> data, RequestExecutor executor) {
                                Log.e("ycwang", data.toString());
                            }
                        })
                        .onDenied(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                Log.e("ycwang", "LOCATION onDenied");
                            }
                        })
                        .start();
            }
        });

    }
}
