
package com.noteapplication.ui.base.rxbus;

import io.reactivex.Observable;

public interface RxBus {

    void send(final Object event);

    Observable<Object> toObservable();

    boolean hasObservers();
}