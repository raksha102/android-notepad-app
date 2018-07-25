
package com.noteapplication.ui.base.recycler_adapter;

import com.noteapplication.data.manager.SessionManagerService;
import com.noteapplication.ui.base.rxbus.RxBus;


/**
 * Contains methods to notify the adapter.
 */
public interface RecyclerAdapterNotifier {

    RxBus getRxBus();

    SessionManagerService getSessionManagerService();

}
