package com.noteapplication.ui.module;


import android.view.MenuItem;

import com.noteapplication.application.events.NavigationEvent;
import com.noteapplication.data.manager.SessionManagerService;
import com.noteapplication.ui.base.BaseActivity;
import com.noteapplication.util.RxEventUtils;

import javax.inject.Inject;

public class NoteBookActivity extends BaseActivity {

    @Inject
    SessionManagerService mSessionManagerService;

    @Override
    protected void initViews() {
        getNavigator().launchNotePadLandingScreen();
    }

    @Override
    protected boolean shouldDisableDrawer() {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                handleHomeButtonClick();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(mSessionManagerService.isNoteBookItemInDeleteState()){
            RxEventUtils.sendEventWithFlag(getRxBus(), NavigationEvent.EVENT_CLEAR_DELETE_FLAG);
        }else {
            super.onBackPressed();
        }
    }
}
