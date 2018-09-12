package com.ycwang.moduleapp.feature;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @author ycwang.
 * @date 2018-8-29.
 */
public class FeatureActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PackageManager manager = getPackageManager();
        if (!manager.hasSystemFeature(PackageManager.FEATURE_SENSOR_COMPASS)) {
            // This device does not have a compass, turn off the compass feature
        }

    }
}
