package com.ycwang.moduleapp.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */

@Dao
public interface UserDao {

    @Insert
    long[] insert(User... user);

    @Insert
    void insert(List<User> list);

    @Update
    void update(User... users);

    @Delete
    void delete(User... users);





}
