package com.ycwang.moduleapp.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */

@Database(entities = {User.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class UserDataBase extends RoomDatabase {

    public abstract UserDao userDao();

}
