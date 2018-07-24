package com.noteapplication.data.datasource;


import com.noteapplication.data.local.db.entity.NoteBookEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface DataBaseDataSource {

    Flowable<List<NoteBookEntity>> getNotes();
}
