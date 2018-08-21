package com.ycwang.moduleapp.dispatchEvent.activity.view;

import android.support.v4.util.ArrayMap;

import com.ycwang.moduleapp.R;
import com.ycwang.moduleapp.dispatchEvent.activity.ModuleManagerActivity;
import com.ycwang.moduleapp.dispatchEvent.activity.config.ModulePageConfig;

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
        map.put(ModulePageConfig.MODULE_PAGE_NAME, new ArrayList<Integer>() {{
            add(R.id.page_name_main);
        }});
        map.put(ModulePageConfig.MODULE_PAGE_BODY, new ArrayList<Integer>() {
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
