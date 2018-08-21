package com.ycwang.moduleapp.annotation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.ycwang.moduleapp.R;


/**
 * @author ycwang.
 * @date 2018-8-20.
 */
public class AnnotationActivity extends Activity {


    @InjectView(R.id.bind_view_btn)
    Button buttonView;

    @InjectView(R.id.bind_click_btn)
    Button buttonClick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);
        Utils.injectView(this);

        buttonView.setText("buttonView" + "+++++++++");
        buttonClick.setText("buttonClick" + "=========");
    }


}
