package com.noteapplication.data.model.mapper;


import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.model.response.main.NoteBookResponse;
import com.noteapplication.data.model.response.sub.NoteBookContent;
import com.noteapplication.injection.scope.ApplicationScope;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@ApplicationScope
public class NoteBookMapper implements Mapper {

    @Inject
    public NoteBookMapper() {
    }

    public List<Note> transform(List<NoteBookEntity> entities) {
        List<Note> notes = new ArrayList<>();
        for(NoteBookEntity entity : entities){
            notes.add(new Note(entity.getId(), entity.getContent(), entity.getModifiedDate()));
        }
        return notes;
    }

    public List<Note> transform(NoteBookResponse notesResponse) {
        List<Note> notes = new ArrayList<>();
        for(NoteBookContent content : notesResponse.getNotes()){
            notes.add(new Note(content.getNoteId(), content.getNote(), content.getDateModified()));
        }
        return notes;
    }
}
