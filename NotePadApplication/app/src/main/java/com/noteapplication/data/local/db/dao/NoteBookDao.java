
package com.noteapplication.data.local.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.noteapplication.application.constants.DBConstants;
import com.noteapplication.data.local.db.entity.NoteBookEntity;

import java.util.List;

import io.reactivex.Flowable;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface NoteBookDao {

    @Insert
    void insert(NoteBookEntity entry);

    @Delete
    void delete(NoteBookEntity entry);

    @Query("DELETE from " + DBConstants.TBL_NOTE_BOOK + " where id = :id")
    void delete(long id);

    @Query("SELECT * FROM " + DBConstants.TBL_NOTE_BOOK + " ORDER BY id  DESC")
    Flowable<List<NoteBookEntity>> getNoteBookData();

    @Query("SELECT COUNT(*) FROM " + DBConstants.TBL_NOTE_BOOK)
    long getCount();

    @Query("SELECT * FROM " + DBConstants.TBL_NOTE_BOOK + " where id = :id ORDER BY id  DESC")
    Flowable<List<NoteBookEntity>> getNoteBookData(String id);

    @Update(onConflict = REPLACE)
    void update(NoteBookEntity entity);

}
