package com.noteapplication.data.repository;


import com.noteapplication.data.model.Note;

import java.util.List;

import io.reactivex.Flowable;

public interface NoteBookRepository {

    Flowable<List<Note>> getNotes();

    NoteBookRepository withPolicy(String cachePolicy);
}
