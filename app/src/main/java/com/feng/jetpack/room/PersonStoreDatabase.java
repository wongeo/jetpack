package com.feng.jetpack.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * 一定要写成抽象类
 */
@Database(entities = {Person.class}, version = 1, exportSchema = false)
public abstract class PersonStoreDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "person";
    private static PersonStoreDatabase INSTANCE;

    public static PersonStoreDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (PersonStoreDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, PersonStoreDatabase.class, DATABASE_NAME).allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract PersonDao getPersonDao();
}
