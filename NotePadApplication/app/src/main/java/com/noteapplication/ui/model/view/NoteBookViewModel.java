package com.noteapplication.ui.model.view;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.util.Logger;

import java.util.List;

public class NoteBookViewModel extends AndroidViewModel {

    private static final String TAG = NoteBookViewModel.class.getSimpleName();
    private final LiveData<List<NoteBookEntity>> mNoteBookLiveData;

    public NoteBookViewModel(@NonNull Application application) {
        super(application);
        mNoteBookLiveData = AppDataBase.getAppDatabase().noteBookDao().getNoteBookData();
    }

    public void saveData(String note) {
        Logger.d(TAG, "Note : "+note);
        AppDataBase.getAppDatabase().noteBookDao().insert(new NoteBookEntity(note));
    }

    public void deleteItem(long id) {
        AppDataBase.getAppDatabase().noteBookDao().delete(id);
    }

    public LiveData<List<NoteBookEntity>> getNoteBookLiveData() {
        return mNoteBookLiveData;
    }
}
