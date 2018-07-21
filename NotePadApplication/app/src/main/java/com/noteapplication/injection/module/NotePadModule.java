package com.noteapplication.injection.module;

import android.content.Context;

import com.noteapplication.injection.scope.ActivityContext;
import com.noteapplication.injection.scope.ContainerId;
import com.noteapplication.ui.base.BaseActivity;
import com.noteapplication.ui.base.navigator.AppNavigator;
import com.noteapplication.ui.base.navigator.AppNavigatorImpl;
import com.noteapplication.ui.module.NoteBookActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module(includes = {NotePadModule.Declaration.class})
public class NotePadModule {

    @Provides
    @ContainerId
    public int provideContainerId(BaseActivity activity) {
        return activity.getContainerId();
    }

    @Module
    public interface Declaration {

        @Binds
        BaseActivity bindsBaseActivity(NoteBookActivity activity);

        @Binds
        @ActivityContext
        Context bindsContext(NoteBookActivity activity);

        @Binds
        AppNavigator bindsAppNavigator(AppNavigatorImpl appNavigator);
    }

}
