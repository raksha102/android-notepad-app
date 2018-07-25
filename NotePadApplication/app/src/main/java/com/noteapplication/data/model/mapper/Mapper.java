package com.noteapplication.data.model.mapper;


import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.model.response.main.NoteBookResponse;

import java.util.List;

/**
 * Data mapper class
 * Converts data from different data source to ui format
 */
public interface Mapper {

    List<Note> transform(List<NoteBookEntity> data);

    List<Note> transform(NoteBookResponse notesResponse);
}
