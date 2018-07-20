/*
 *  Copyright © 2018, Cognizant Technology Solutions.
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package com.noteapplication.domain.executor;


import io.reactivex.Scheduler;

public interface ThreadExecutor {

    Scheduler getScheduler();
}
