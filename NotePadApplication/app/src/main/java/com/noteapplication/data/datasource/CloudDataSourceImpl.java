package com.noteapplication.data.datasource;


import com.noteapplication.data.ApiService;
import com.noteapplication.data.model.response.main.NoteBookResponse;
import com.noteapplication.injection.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.Flowable;

@ApplicationScope
public class CloudDataSourceImpl implements CloudDataSource{

    private final ApiService mApiService;

    @Inject
    public CloudDataSourceImpl(ApiService apiService) {
        mApiService = apiService;
    }

    public Flowable<NoteBookResponse> getNotes() {
       return mApiService.getNotes();
    }
}
