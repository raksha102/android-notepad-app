package com.noteapplication.data.model;

public class Note {
    private String text;
    private long id;
    private long modifiedDate;

    public Note(long id, String content, long modifiedDate) {
        this.text = content;
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
