
package com.noteapplication.data.local.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import com.noteapplication.application.NotePadApplication;
import com.noteapplication.application.constants.DBConstants;
import com.noteapplication.data.local.db.dao.NoteBookDao;
import com.noteapplication.data.local.db.entity.NoteBookEntity;

@Database(entities = {NoteBookEntity.class}, version = DBConstants.DB_VERSION, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    private static AppDataBase INSTANCE;

    public static AppDataBase getAppDatabase() {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(NotePadApplication.getApplicationInstance(), AppDataBase.class, DBConstants.DB_NAME)
                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract NoteBookDao noteBookDao();
}