/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.noteapplication.application;

import android.app.Activity;
import android.app.Application;

import com.noteapplication.injection.component.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class NotePadApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private static NotePadApplication sInstance;

    public NotePadApplication() {
        sInstance = this;
    }

    public static NotePadApplication getApplicationInstance() {
        return sInstance;
    }

   /* @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }*/

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
