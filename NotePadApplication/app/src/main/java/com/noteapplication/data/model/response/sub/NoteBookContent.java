package com.noteapplication.data.model.response.sub;


import com.google.gson.annotations.SerializedName;

public class NoteBookContent {

    @SerializedName("note_id")
    private long noteId;

    @SerializedName("note")
    private String note;

    @SerializedName("dateModified")
    private long dateModified;

    public long getNoteId() {
        return noteId;
    }

    public String getNote() {
        return note;
    }

    public long getDateModified() {
        return dateModified;
    }
}
