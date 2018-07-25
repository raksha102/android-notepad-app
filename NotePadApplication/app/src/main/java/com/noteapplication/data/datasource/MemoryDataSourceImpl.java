package com.noteapplication.data.datasource;


import com.noteapplication.data.model.response.main.NoteBookResponse;
import com.noteapplication.injection.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.Flowable;

@ApplicationScope
public class MemoryDataSourceImpl implements MemoryDataSource {

    @Inject
    public MemoryDataSourceImpl() {
    }

    @Override
    public Flowable<NoteBookResponse> getNotes() {
        return null;
    }
}
