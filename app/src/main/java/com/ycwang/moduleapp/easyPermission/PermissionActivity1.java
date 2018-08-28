package com.ycwang.moduleapp.easyPermission;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-28.
 */

@Route(path = MainConstant.APP_MODULE_EASY_PERMISSION)
public class PermissionActivity1 extends PermissionBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);

        findViewById(R.id.btn_permission).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String[] permissions = {EXTERNAL_STORAGE};
                performCodeWithPermission("XXXXXXrationale", 1001, permissions, new PermissionCallback() {
                    @Override
                    public void hasPermission(List<String> allPerms) {
                        Log.e("ycwang", "hasPermission");

                    }

                    @Override
                    public void noPermission(List<String> deniedPerms, List<String> grantedPerms, Boolean hasPermanentlyDenied) {
                        Log.e("ycwang", "noPermission   " + deniedPerms.toString() + "  " + grantedPerms.toString() + "   " + hasPermanentlyDenied);
                        if (!grantedPerms.contains(EXTERNAL_STORAGE)) {
                            alertAppSetPermission("请去设置页面设置权限");
                        }

                    }
                });
            }
        });
    }
}
