
package com.noteapplication.ui.base.recycler_adapter;

import android.os.Bundle;

import com.noteapplication.data.manager.SessionManagerService;
import com.noteapplication.ui.base.rxbus.RxBus;


/**
 * Contains methods to notify the adapter.
 *
 */
public interface RecyclerAdapterNotifier {
    void sendEvent(RecyclerAdapterViewHolder holder, Bundle data);

    RxBus getRxBus();

    SessionManagerService getSessionManagerService();

}