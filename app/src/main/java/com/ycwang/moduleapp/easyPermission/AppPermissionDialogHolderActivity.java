package com.ycwang.moduleapp.easyPermission;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-31.
 */
public class AppPermissionDialogHolderActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
    }
}
