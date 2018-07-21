package com.noteapplication.injection.module;

import com.noteapplication.ui.module.detail.NotePadFragment;
import com.noteapplication.ui.module.landing.NotePadLandingFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class NotePadFragmentProvider {

    @ContributesAndroidInjector
    abstract NotePadFragment bindNotePadFragment();

    @ContributesAndroidInjector
    abstract NotePadLandingFragment bindNotePadLandingFragment();
}
