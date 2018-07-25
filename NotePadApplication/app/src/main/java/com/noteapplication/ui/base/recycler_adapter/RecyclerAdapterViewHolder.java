
package com.noteapplication.ui.base.recycler_adapter;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.noteapplication.BR;
import com.noteapplication.data.manager.SessionManagerService;
import com.noteapplication.ui.base.rxbus.RxBus;

import java.lang.ref.WeakReference;

import butterknife.ButterKnife;

/**
 * Base ViewHolder class to extend in subclasses.
 */
public abstract class RecyclerAdapterViewHolder extends RecyclerView.ViewHolder {

    private final WeakReference<RecyclerAdapterNotifier> adapter;

    private ViewDataBinding binding;

    private RxBus mRxBus;
    private SessionManagerService mSessionManagerService;

    public RecyclerAdapterViewHolder(ViewDataBinding itemView, RecyclerAdapterNotifier adapter) {
        super(itemView.getRoot());
        ButterKnife.bind(this, itemView.getRoot());
        this.binding = itemView;
        this.adapter = new WeakReference<>(adapter);
        mRxBus = adapter.getRxBus();
        mSessionManagerService = adapter.getSessionManagerService();
    }

    protected void bind(Object object) {
        if (object != null) {
            binding.setVariable(BR.data, object);
            binding.executePendingBindings();
        }
    }

    protected final View findViewById(int id) {
        return itemView.findViewById(id);
    }

    public ViewDataBinding getBinder() {
        return binding;
    }

    public RxBus getRxBus() {
        return mRxBus;
    }

    public SessionManagerService getSessionManagerService() {
        return mSessionManagerService;
    }
}
