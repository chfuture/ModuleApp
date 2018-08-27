package com.ycwang.moduleapp.room;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ycwang.global.MainConstant;
import com.ycwang.moduleapp.R;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */

@Route(path = MainConstant.APP_MODULE_ROOM)
public class RoomActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

    }
}
