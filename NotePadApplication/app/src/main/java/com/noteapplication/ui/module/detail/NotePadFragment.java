package com.noteapplication.ui.module.detail;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.noteapplication.R;
import com.noteapplication.databinding.FragmentNotePadBinding;
import com.noteapplication.ui.base.BaseFragment;
import com.noteapplication.ui.model.data.AppToolbar;
import com.noteapplication.ui.model.view.NoteBookViewModel;
import com.noteapplication.util.Logger;

import javax.inject.Inject;

import butterknife.BindView;

public class NotePadFragment extends BaseFragment {

    private static final String TAG = NotePadFragment.class.getSimpleName();

    @BindView(R.id.txt_note)
    TextView mTxtNote;

    @Inject
    NoteBookViewModel mViewModel;

    private boolean isSaving = false;

    public static NotePadFragment newInstance() {

        Bundle args = new Bundle();

        NotePadFragment fragment = new NotePadFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected View inflateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentNotePadBinding binder = DataBindingUtil.inflate(inflater, getFragmentLayoutId(), container, false);
        return binder.getRoot();
    }

    @Override
    public void onEventTrigger(Object event) {

    }

    @Override
    protected int getFragmentLayoutId() {
        return R.layout.fragment_note_pad;
    }

    @Override
    protected void initViews(View view) {
        Logger.i(TAG, "ViewModel :" + mViewModel);
        setHasOptionsMenu(true);
        if (mViewModel.getSelectedItem() != null) {
            mTxtNote.setText(mViewModel.getSelectedItem().getText());
        }
    }

    @Override
    public AppToolbar getToolBarSetting() {
        return new AppToolbar.AppToolBarBuilder(true)
                .setBackButtonEnabled(true)
                .setTitle(getString(R.string.title_add_note))
                .setSaveEnabled(true)
                .build();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.menu_save:
                handleSaveButtonClick();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void handleSaveButtonClick() {

        if (isSaving) return;

        isSaving = true;
        getNavigator().hideKeyBoard();
        mViewModel.saveData(mTxtNote.getText().toString());
        getActivity().onBackPressed();
    }
}
