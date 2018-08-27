package com.ycwang.moduleapp.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */

@Entity(foreignKeys = @ForeignKey(
        entity = User.class,
        parentColumns = "_id",
        childColumns = "user_id"))
public class Book {

    @ColumnInfo(name = "user_id")
    public int userId;

    @ColumnInfo(name = "book_id")
    @PrimaryKey(autoGenerate = true)
    public int bookId;

    public String title;

}
