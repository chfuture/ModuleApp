package com.ycwang.moduleapp.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;

import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */

@Entity(tableName = "user",
        indices = {@Index(value = "first_name", unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    public int _id;

    @ColumnInfo(name = "first_name")
    public String name;


    @Embedded
    public Address address;

    public int age;

    public int userId;

}
