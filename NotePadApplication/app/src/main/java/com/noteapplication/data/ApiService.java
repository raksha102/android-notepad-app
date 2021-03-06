package com.noteapplication.data;


import com.noteapplication.data.model.response.main.NoteBookResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/notes")
    Flowable<NoteBookResponse> getNotes();
}
