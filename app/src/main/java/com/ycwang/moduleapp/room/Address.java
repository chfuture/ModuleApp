package com.ycwang.moduleapp.room;

import android.arch.persistence.room.ColumnInfo;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */
public class Address {


    public String street;

    public String state;

    public String city;

    @ColumnInfo(name = "post_code")
    public String postCode;

}
