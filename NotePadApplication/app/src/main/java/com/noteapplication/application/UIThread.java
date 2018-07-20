/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.noteapplication.application;


import com.noteapplication.domain.executor.PostExecutionThread;
import com.noteapplication.injection.scope.ApplicationScope;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * MainThread (UI Thread) implementation based on a {@link Scheduler}
 * which will execute actions on the Android UI thread
 */
@ApplicationScope
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
