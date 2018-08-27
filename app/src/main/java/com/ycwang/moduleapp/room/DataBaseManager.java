package com.ycwang.moduleapp.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

import com.ycwang.moduleapp.global.App;

/**
 * @author ycwang.
 * @date 2018-8-27.
 */
public class DataBaseManager {


    public static UserDataBase getUserDataBase() {
        return UserDatabase.DATABASE;
    }

    public static class UserDatabase {
        static final UserDataBase DATABASE = Room
                .databaseBuilder(App.getContext(), UserDataBase.class, "room.db")
                .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                .build();
    }




    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, "
                    + "`name` TEXT, PRIMARY KEY(`id`))");
        }
    };

    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Book "
                    + " ADD COLUMN pub_year INTEGER");
        }
    };
}
