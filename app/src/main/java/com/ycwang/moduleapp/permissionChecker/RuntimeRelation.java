package com.ycwang.moduleapp.permissionChecker;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;

import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.ycwang.moduleapp.R;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-16.
 */
public class RuntimeRelation implements Rationale<List<String>> {


    @Override
    public void showRationale(Context context, List<String> data, final RequestExecutor executor) {

        List<String> permissionNames = Permission.transformText(context, data);
        String message = context.getString(R.string.message_permission_always_failed,
                TextUtils.join("\n", permissionNames));



        new AlertDialog.Builder(context)
                .setTitle("需要的权限")
                .setMessage(message)
                .setPositiveButton("同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        executor.execute();
                    }
                })
                .setNegativeButton("不同意", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        executor.cancel();
                    }
                })
                .show();

    }
}
