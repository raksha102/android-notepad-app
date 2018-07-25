package com.noteapplication.data.datasource;


import com.noteapplication.data.model.response.main.NoteBookResponse;

import io.reactivex.Flowable;

/**
 * file system data source
 */
public interface MemoryDataSource {

    Flowable<NoteBookResponse> getNotes();
}
