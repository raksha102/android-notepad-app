package com.noteapplication.data.model;

public class Note {
    private String text;
    private long id;
    private long modifiedDate;

    public Note(String text, long id, long modifiedDate) {
        this.text = text;
        this.id = id;
        this.modifiedDate = modifiedDate;
    }

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }
}
