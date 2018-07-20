
package com.noteapplication.ui.viewitem;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.noteapplication.R;
import com.noteapplication.ui.base.recycler_adapter.AdapterItem;
import com.noteapplication.ui.base.recycler_adapter.RecyclerAdapterNotifier;
import com.noteapplication.ui.base.recycler_adapter.RecyclerAdapterViewHolder;

public class BlankViewItem extends AdapterItem<BlankViewItem.Holder> {


    public BlankViewItem() {

    }

    @Override
    public boolean onFilter(String searchTerm) {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_blank_view;

    }

    @Override
    public Object getData() {
        return null;
    }

    @Override
    public void setData(Object obj) {

    }

    @Override
    protected void bindData(Holder holder, Object data, int position) {
    }

    @Override
    public boolean onEvent(int position, Bundle data) {
        return false;
    }

    @Override
    protected void onViewRecycled(Holder holder) {

    }

    public static class Holder extends RecyclerAdapterViewHolder {

        public Holder(ViewDataBinding itemView, RecyclerAdapterNotifier adapter) {
            super(itemView, adapter);
        }
    }
}