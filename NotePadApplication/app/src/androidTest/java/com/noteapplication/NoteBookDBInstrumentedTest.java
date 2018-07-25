package com.noteapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.local.db.dao.NoteBookDao;
import com.noteapplication.data.local.db.entity.NoteBookEntity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import io.reactivex.Flowable;

@RunWith(AndroidJUnit4.class)
public class NoteBookDBInstrumentedTest {

    private NoteBookDao mUserDao;
    private AppDataBase mDb;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDataBase.class).build();
        mUserDao = mDb.noteBookDao();
    }

    @After
    public void closeDb() throws IOException {
        mDb.close();
    }

    @Test
    public void testItemInsert() throws Exception {
        NoteBookEntity entity = new NoteBookEntity("test");
        mUserDao.insert(entity);
        Flowable<List<NoteBookEntity>> entities = mUserDao.getNoteBookData();
        entities.test().assertNoErrors().assertValue(noteBookEntities ->
                noteBookEntities.size() == 1);
    }
}