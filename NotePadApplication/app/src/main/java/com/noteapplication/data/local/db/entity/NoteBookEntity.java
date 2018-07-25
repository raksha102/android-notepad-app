package com.noteapplication.data.local.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.noteapplication.application.constants.DBConstants;

@Entity(tableName = DBConstants.TBL_NOTE_BOOK)
public class NoteBookEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private long id;

    private String content;

    private long modifiedDate;

    public NoteBookEntity() {
    }

    public NoteBookEntity(String note) {
        content = note;
        modifiedDate = System.currentTimeMillis();
    }

    public NoteBookEntity(long id, String note) {
        this.id = id;
        this.content = note;
        modifiedDate = System.currentTimeMillis();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(long modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
