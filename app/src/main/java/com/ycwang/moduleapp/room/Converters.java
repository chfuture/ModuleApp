package com.ycwang.moduleapp.room;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */
public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }


}
