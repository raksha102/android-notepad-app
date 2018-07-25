package com.noteapplication.data.model.response.main;


import com.google.gson.annotations.SerializedName;
import com.noteapplication.data.model.response.sub.NoteBookContent;

import java.util.List;

public class NoteBookResponse {

    @SerializedName("notes")
    List<NoteBookContent> notes;

    public List<NoteBookContent> getNotes() {
        return notes;
    }
}
