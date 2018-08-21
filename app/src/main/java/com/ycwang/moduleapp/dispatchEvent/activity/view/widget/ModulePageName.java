package com.ycwang.moduleapp.dispatchEvent.activity.view.widget;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ycwang.moduleapp.R;
import com.ycwang.moduleapp.dispatchEvent.activity.baseManager.CWBaseModule;
import com.ycwang.moduleapp.dispatchEvent.activity.baseManager.CWModuleContext;

/**
 * @author ycwang.
 * @date 2018-8-21.
 */
public class ModulePageName extends CWBaseModule {

    private Activity activity;

    private ViewGroup viewGroup;

    private View pageName;

    private TextView pageTitle;


    @Override
    public void init(CWModuleContext moduleContext, String extend) {
        super.init(moduleContext, extend);
        activity = moduleContext.getContext();
        viewGroup = moduleContext.getViewGroups().get(0);
        this.moduleContext = moduleContext;
        initView();

    }

    private void initView() {
        pageName = LayoutInflater.from(activity).inflate(R.layout.page_name, null);
        viewGroup.addView(pageName);
        pageTitle = pageName.findViewById(R.id.txw_page_name);

        pageTitle.setText("Module Page Name");
    }
}
