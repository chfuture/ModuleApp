package com.ycwang.moduleapp.dispatchEvent.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.util.SparseArrayCompat;
import android.view.ViewGroup;

/**
 * @author ycwang
 * @date 2018/8/20.
 */
public class CWModuleContext {

    private Activity context;

    private Bundle saveInstanceState;

    private SparseArrayCompat<ViewGroup> viewGroups = new SparseArrayCompat<>();


    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public Bundle getSaveInstanceState() {
        return saveInstanceState;
    }

    public void setSaveInstanceState(Bundle saveInstanceState) {
        this.saveInstanceState = saveInstanceState;
    }

    public SparseArrayCompat<ViewGroup> getViewGroups() {
        return viewGroups;
    }

    public void setViewGroups(SparseArrayCompat<ViewGroup> viewGroups) {
        this.viewGroups = viewGroups;
    }
}
