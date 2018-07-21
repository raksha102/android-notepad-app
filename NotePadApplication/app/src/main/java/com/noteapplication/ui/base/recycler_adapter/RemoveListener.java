

package com.noteapplication.ui.base.recycler_adapter;

/**
 * Listener invoked for every element that is going to be removed.
 *
 */

public interface RemoveListener {
    boolean hasToBeRemoved(AdapterItem item);
}
