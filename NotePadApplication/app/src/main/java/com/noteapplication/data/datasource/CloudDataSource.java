package com.noteapplication.data.datasource;


import com.noteapplication.data.model.response.main.NoteBookResponse;

import io.reactivex.Flowable;

public interface CloudDataSource {

    Flowable<NoteBookResponse> getNotes();
}
