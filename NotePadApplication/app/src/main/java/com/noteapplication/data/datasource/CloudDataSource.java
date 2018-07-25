package com.noteapplication.data.datasource;


import com.noteapplication.data.model.response.main.NoteBookResponse;

import io.reactivex.Flowable;

/**
 * Data stored in cloud
 * REST - Api call will be made to fetch data
 */
public interface CloudDataSource {

    Flowable<NoteBookResponse> getNotes();
}
