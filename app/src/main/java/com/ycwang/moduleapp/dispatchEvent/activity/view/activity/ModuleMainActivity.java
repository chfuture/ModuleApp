package com.ycwang.moduleapp.dispatchEvent.activity.view.activity;

import android.support.v4.util.ArrayMap;

import com.ycwang.moduleapp.R;
import com.ycwang.moduleapp.dispatchEvent.activity.baseManager.ModuleManagerActivity;
import com.ycwang.moduleapp.global.MainPageConfig;

import java.util.ArrayList;

/**
 * @author ycwang.
 * @date 2018-8-21.
 */
public class ModuleMainActivity extends ModuleManagerActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_module_main;
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        ArrayMap<String, ArrayList<Integer>> map = new ArrayMap<>();
        map.put(MainPageConfig.MODULE_PAGE_NAME, new ArrayList<Integer>() {{
            add(R.id.page_name_main);
        }});
        map.put(MainPageConfig.MODULE_PAGE_BODY, new ArrayList<Integer>() {
            {
                add(R.id.page_bodyB);
            }

            {
                add(R.id.page_bodyT);
            }
        });
        return map;
    }
}
