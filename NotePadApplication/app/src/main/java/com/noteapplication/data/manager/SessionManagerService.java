package com.noteapplication.data.manager;


public interface SessionManagerService {

    boolean isNoteBookItemInDeleteState();

    void setNoteBookItemSelected(boolean noteBookItemSelected);
}
