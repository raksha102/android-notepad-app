
package com.noteapplication.domain.executor;


import io.reactivex.Scheduler;

public interface ThreadExecutor {

    Scheduler getScheduler();
}
