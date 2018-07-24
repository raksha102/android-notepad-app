package com.noteapplication.data.model.mapper;


import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.model.response.main.NoteBookResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class NoteBookMapper {

    @Inject
    public NoteBookMapper() {
    }

    public List<Note> transform(List<NoteBookEntity> data) {
        List<Note> notes = new ArrayList<>();
        return notes;
    }

    public List<Note> transform(NoteBookResponse notesResponse) {
        List<Note> notes = new ArrayList<>();
        return notes;
    }
}
