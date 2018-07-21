package com.noteapplication.data.manager;


import com.noteapplication.injection.scope.ApplicationScope;

import javax.inject.Inject;

@ApplicationScope
public class SessionManager implements SessionManagerService {

    private boolean bNoteBookItemSelected;

    @Inject
    public SessionManager() {
    }

    @Override
    public boolean isNoteBookItemInDeleteState() {
        return bNoteBookItemSelected;
    }

    @Override
    public void setNoteBookItemSelected(boolean noteBookItemSelected) {
        this.bNoteBookItemSelected = noteBookItemSelected;
    }
}
