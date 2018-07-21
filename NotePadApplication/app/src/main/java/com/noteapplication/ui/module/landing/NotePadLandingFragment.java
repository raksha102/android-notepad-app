package com.noteapplication.ui.module.landing;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.noteapplication.R;
import com.noteapplication.application.events.NavigationEvent;
import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.databinding.FragmentNotePadLandingBinding;
import com.noteapplication.ui.base.BaseFragment;
import com.noteapplication.ui.base.recycler_adapter.AdapterItem;
import com.noteapplication.ui.base.recycler_adapter.RecyclerAdapter;
import com.noteapplication.ui.model.data.AppToolbar;
import com.noteapplication.ui.model.view.NoteBookViewModel;
import com.noteapplication.ui.viewitem.NoteBookViewItem;
import com.noteapplication.util.Logger;

import java.util.List;

public class NotePadLandingFragment extends BaseFragment {

    private static final String TAG = NotePadLandingFragment.class.getSimpleName();
    private RecyclerAdapter mAdapter;
    private NoteBookViewModel mViewModel;

    public static NotePadLandingFragment newInstance() {

        Bundle args = new Bundle();

        NotePadLandingFragment fragment = new NotePadLandingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNotePadLandingBinding binder = DataBindingUtil.inflate(inflater, getFragmentLayoutId(), container, false);
        setUpRecyclerView(binder);
        return binder.getRoot();
    }

    private void setUpRecyclerView(FragmentNotePadLandingBinding binder) {
        binder.rvNoteBook.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new RecyclerAdapter(getRxBus(), getSessionManagerService());
        binder.rvNoteBook.setAdapter(mAdapter);
    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_note_pad_landing;
    }

    @Override
    protected void initViews(View view) {
        setHasOptionsMenu(true);
        mViewModel =
                ViewModelProviders.of(getActivity()).get(NoteBookViewModel.class);
        mViewModel.getNoteBookLiveData().observe(getActivity(), noteBookEntities -> updateItems(noteBookEntities));
    }

    private void updateItems(List<NoteBookEntity> noteBookEntities) {
        Logger.d(TAG, "NoteBookViewModel : updateItems");
        mAdapter.clear();
        if (noteBookEntities == null || noteBookEntities.size() <= 0) return;
        AdapterItem viewItem;
        for (NoteBookEntity entity : noteBookEntities) {
            viewItem = new NoteBookViewItem();
            viewItem.setData(entity);
            mAdapter.add(viewItem);
        }
    }

    @Override
    protected void handleNavigationEvents(NavigationEvent event) {
        super.handleNavigationEvents(event);

        switch (event.getFlag()) {
            case NavigationEvent.EVENT_ON_NOTE_BOOK_ITEM_LONG_CLICK:
                onItemLongClick((NoteBookEntity)event.getData());
                break;
        }
    }

    private void onItemLongClick(NoteBookEntity data) {
        mViewModel.deleteItem(data.getId());
    }

    @Override
    public AppToolbar getToolBarSetting() {
        return new AppToolbar.AppToolBarBuilder(true)
                .setBackButtonEnabled(false)
                .setTitle(getString(R.string.title_note_book))
                .setAddEnabled(true)
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                handleAddMenuClick();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void handleAddMenuClick() {
        getNavigator().launchNotePadScreen();
    }
}
