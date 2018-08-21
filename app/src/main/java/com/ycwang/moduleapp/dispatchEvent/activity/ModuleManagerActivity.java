package com.ycwang.moduleapp.dispatchEvent.activity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
public abstract class ModuleManagerActivity extends AppCompatActivity {

    private ActivityModuleManager moduleManager;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        moduleManager = new ActivityModuleManager();
        moduleManager.initModules(savedInstanceState, ModuleManagerActivity.this, moduleConfig());

    }

    public abstract int getLayoutId();

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        moduleManager.onResume();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onPause() {
        super.onPause();
        moduleManager.onPause();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onStop() {
        super.onStop();
        moduleManager.onStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        moduleManager.onDestroy();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        moduleManager.onOrientationChanges(newConfig.isScreenHdr());
    }
}
