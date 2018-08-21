package com.ycwang.moduleapp.permission;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Setting;
import com.ycwang.moduleapp.App;
import com.ycwang.moduleapp.R;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-14.
 */
// 拦截器
@Interceptor(priority = 7, name = "aasj")
public class TestInterceptor implements IInterceptor {

    private Context mContext;



    @Override
    public void process(final Postcard postcard, final InterceptorCallback callback) {

        App.getTopActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // 拦截 /test/myliba 的跳转
                if (TextUtils.equals("/test/myliba", postcard.getPath())) {
                    Log.e("ycwang", "您需要进行登录才能使用该功能");
                    Log.e("ycwang", "需要SD卡权限才可以进入该页面");

                    AndPermission.with(App.getTopActivity())
                            .runtime()
                            .permission(Permission.Group.CAMERA)
                            .rationale(new RuntimeRelation())
                            .onDenied(new Action<List<String>>() {
                                @Override
                                public void onAction(List<String> data) {
                                    Toast.makeText(mContext, "拒绝", Toast.LENGTH_SHORT).show();
                                    if (AndPermission.hasAlwaysDeniedPermission(mContext, data)) {
                                        requestConfirmPermission(data);
                                    }
                                }
                            }).onGranted(new Action<List<String>>() {
                        @Override
                        public void onAction(List<String> data) {
                            Toast.makeText(mContext, "同意", Toast.LENGTH_SHORT).show();
                            callback.onContinue(postcard);
                        }
                    }).start();

                } else {
                    callback.onContinue(postcard);
                }
            }
        });


    }

    private void requestConfirmPermission(List<String> data) {
        List<String> permissionNames = Permission.transformText(mContext, data);
        String message = mContext.getString(R.string.message_permission_always_failed,
                TextUtils.join("\n", permissionNames));

        new AlertDialog.Builder(mContext).setCancelable(false).setTitle("权限请求").setMessage(message)
                .setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        setPermission();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).show();
    }

    private void setPermission() {
        AndPermission.with(mContext).runtime().setting()
                .onComeback(new Setting.Action() {
                    @Override
                    public void onAction() {
                        Toast.makeText(mContext, "请设置权限", Toast.LENGTH_SHORT).show();
                    }
                }).start();
    }

    @Override
    public void init(Context context) {
        this.mContext = context;
    }
}
