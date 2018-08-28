package com.ycwang.moduleapp.easyPermission;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * @author ycwang.
 * @date 2018-8-28.
 */
public class PermissionBaseActivity extends Activity implements EasyPermissions.PermissionCallbacks {


    // ****************************** 权限管理 start *************************************
    protected static final String CAMERA = Manifest.permission.CAMERA;
    protected static final String LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;
    protected static final String EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    protected static final String READ_SMS = Manifest.permission.READ_SMS;
    protected static final String RECEIVE_SMS = Manifest.permission.RECEIVE_SMS;

    private Map<Integer, PermissionCallback> mPermissionCallbacks = null;
    private Map<Integer, String[]> mPermissions = null;

    protected interface PermissionCallback {
        /**
         * has all permission
         *
         * @param allPerms all permissions
         */
        void hasPermission(List<String> allPerms);

        /**
         * denied some permission
         *
         * @param deniedPerms          denied permission
         * @param grantedPerms         granted permission
         * @param hasPermanentlyDenied has permission denied permanently
         */
        void noPermission(List<String> deniedPerms, List<String> grantedPerms, Boolean hasPermanentlyDenied);
    }

    /**
     * request permission
     *
     * @param rationale   if denied first, next request rationale
     * @param requestCode requestCode
     * @param perms       permissions
     * @param callback    callback
     */
    protected void performCodeWithPermission(@NonNull String rationale,
                                             final int requestCode, @NonNull String[] perms, @NonNull PermissionCallback callback) {
        if (EasyPermissions.hasPermissions(this, perms)) {
            callback.hasPermission(Arrays.asList(perms));
        } else {
            if (mPermissionCallbacks == null) {
                mPermissionCallbacks = new HashMap<>();
            }
            mPermissionCallbacks.put(requestCode, callback);

            if (mPermissions == null) {
                mPermissions = new HashMap<>();
            }
            mPermissions.put(requestCode, perms);

            EasyPermissions.requestPermissions(this, rationale, requestCode, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        if (mPermissionCallbacks == null || !mPermissionCallbacks.containsKey(requestCode)) {
            return;
        }
        if (mPermissions == null || !mPermissions.containsKey(requestCode)) {
            return;
        }

        // 100% granted permissions
        if (mPermissions.get(requestCode).length == perms.size()) {
            mPermissionCallbacks.get(requestCode).hasPermission(Arrays.asList(mPermissions.get(requestCode)));
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        if (mPermissionCallbacks == null || !mPermissionCallbacks.containsKey(requestCode)) {
            return;
        }
        if (mPermissions == null || !mPermissions.containsKey(requestCode)) {
            return;
        }

        //granted permission
        List<String> grantedPerms = new ArrayList<>();
        for (String perm : mPermissions.get(requestCode)) {
            if (!perms.contains(perm)) {
                grantedPerms.add(perm);
            }
        }

        //check has permission denied permanently
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            mPermissionCallbacks.get(requestCode).noPermission(perms, grantedPerms, true);
        } else {
            mPermissionCallbacks.get(requestCode).noPermission(perms, grantedPerms, false);
        }
    }


    /**
     * alert AppSet Permission
     *
     * @param rationale alert setting rationale
     */
    protected void alertAppSetPermission(String rationale) {
        new AppSettingsDialog.Builder(this)
                .setTitle("权限请求")
                .setPositiveButton("设置")
                .setNegativeButton("取消")
                .setRationale(rationale)
                .build()
                .show();
    }

    /**
     * alert AppSet Permission
     *
     * @param rationale   alert setting rationale
     * @param requestCode onActivityResult requestCode
     */
    protected void alertAppSetPermission(String rationale, int requestCode) {
        new AppSettingsDialog.Builder(this)
                .setTitle("权限请求")
                .setPositiveButton("设置")
                .setNegativeButton("取消")
                .setRationale(rationale)
                .setRequestCode(requestCode)
                .build()
                .show();
    }

    // ****************************** 权限管理 end *************************************
}
