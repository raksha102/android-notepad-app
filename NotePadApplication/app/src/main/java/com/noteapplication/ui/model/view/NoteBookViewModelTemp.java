package com.noteapplication.ui.model.view;


import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;

import com.noteapplication.application.NotePadApplication;
import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.util.Logger;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class NoteBookViewModelTemp extends AndroidViewModel {

    private static final String TAG = NoteBookViewModelTemp.class.getSimpleName();
    private LiveData<List<Note>> mNoteBookLiveData;
    private final NoteBookRepository mNoteBookRepository;

    @Inject
    public NoteBookViewModelTemp(NoteBookRepository noteBookRepository) {
        super(NotePadApplication.getApplicationInstance());
        mNoteBookRepository = noteBookRepository;
        getData();
    }

    public void getData() {
        mNoteBookLiveData = LiveDataReactiveStreams.fromPublisher(mNoteBookRepository.getNotes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()));
    }

    public void saveData(String note) {
        Logger.d(TAG, "Note : " + note);
        AppDataBase.getAppDatabase().noteBookDao().insert(new NoteBookEntity(note));
    }

    public void deleteItem(long id) {
        AppDataBase.getAppDatabase().noteBookDao().delete(id);
    }

    public LiveData<List<Note>> getNoteBookLiveData() {
        return mNoteBookLiveData;
    }
}
