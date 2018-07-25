package com.noteapplication.data.datasource;


import com.noteapplication.data.local.db.entity.NoteBookEntity;

import java.util.List;

import io.reactivex.Flowable;

/**
 * Data will be store in database
 *
 */
public interface DataBaseDataSource {

    Flowable<List<NoteBookEntity>> getNotes();

    void saveNotes(NoteBookEntity noteBookEntity);

    void updateNotes(long id, String note);

    void delete(long id);
}
