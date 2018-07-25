
package com.noteapplication.ui.viewitem;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.noteapplication.BR;
import com.noteapplication.R;
import com.noteapplication.application.constants.AppConstants;
import com.noteapplication.application.events.NavigationEvent;
import com.noteapplication.data.model.Note;
import com.noteapplication.databinding.ItemNoteBookBinding;
import com.noteapplication.ui.base.recycler_adapter.AdapterItem;
import com.noteapplication.ui.base.recycler_adapter.RecyclerAdapterNotifier;
import com.noteapplication.ui.base.recycler_adapter.RecyclerAdapterViewHolder;
import com.noteapplication.util.RxEventUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;

public class NoteBookViewItem extends AdapterItem<NoteBookViewItem.Holder> {

    private Note mData;

    @Override
    public boolean onFilter(String searchTerm) {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.item_note_book;
    }

    @Override
    public Object getData() {
        return mData;
    }

    @Override
    public void setData(Object obj) {
        mData = (Note) obj;
    }

    @Override
    protected void bindData(Holder holder, Object data, int position) {
        ItemNoteBookBinding binder = (ItemNoteBookBinding) holder.getBinder();
        binder.setPosition(position);
        binder.setShowDelete(false);
        binder.notifyPropertyChanged(BR.showDelete);
        binder.notifyPropertyChanged(BR.position);
        binder.executePendingBindings();

        binder.layoutNoteItem.setOnLongClickListener(v -> {
            updateDeleteFlag(holder, true, binder);
            return true;
        });

        binder.layoutNoteItem.setOnClickListener(v -> RxEventUtils.sendEventWithDataAndType(holder.getRxBus(), NavigationEvent.EVENT_ON_NOTE_BOOK_ITEM_CLICK, mData, AppConstants.LANDING_SCREEN));

        binder.btnDelete.setOnClickListener(v ->
                RxEventUtils.sendEventWithDataAndType(holder.getRxBus(), NavigationEvent.EVENT_ON_NOTE_BOOK_ITEM_LONG_CLICK, mData, AppConstants.LANDING_SCREEN));

        holder.getRxBus().toObservable()
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>) o ->
                        o instanceof NavigationEvent && ((NavigationEvent) o).getFlag().equals(NavigationEvent.EVENT_CLEAR_DELETE_FLAG))
                .cast(NavigationEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(navigationEvent ->
                        updateDeleteFlag(holder, false, binder));
    }

    private void updateDeleteFlag(Holder holder, boolean showDelete, ItemNoteBookBinding binder) {
        holder.getSessionManagerService().setNoteBookItemSelected(showDelete);
        binder.setShowDelete(showDelete);
        binder.notifyPropertyChanged(BR.showDelete);
        binder.executePendingBindings();
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