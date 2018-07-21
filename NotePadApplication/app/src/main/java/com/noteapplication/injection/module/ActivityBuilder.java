package com.noteapplication.injection.module;

import com.noteapplication.injection.scope.ActivityScope;
import com.noteapplication.ui.module.NoteBookActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = {NotePadModule.class, NotePadFragmentProvider.class})
    abstract NoteBookActivity bindNoteBookActivity();
}
