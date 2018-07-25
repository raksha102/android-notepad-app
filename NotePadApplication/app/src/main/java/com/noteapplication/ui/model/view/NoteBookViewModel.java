package com.noteapplication.ui.model.view;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;
import android.arch.lifecycle.ViewModel;

import com.noteapplication.application.events.NavigationEvent;
import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.injection.scope.ActivityScope;
import com.noteapplication.ui.base.navigator.AppNavigator;
import com.noteapplication.ui.base.rxbus.RxBus;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;
import io.reactivex.schedulers.Schedulers;

@ActivityScope
public class NoteBookViewModel extends ViewModel {

    private final AppNavigator mNavigator;
    private final RxBus mRxBus;
    private LiveData<List<Note>> mNoteBookLiveData;
    private final NoteBookRepository mNoteBookRepository;
    private Note mSelectedItem;

    @Inject
    public NoteBookViewModel(NoteBookRepository noteBookRepository, AppNavigator navigator, RxBus rxBus) {
        mNoteBookRepository = noteBookRepository;
        mNavigator = navigator;
        mRxBus = rxBus;
        getData();
        listenNoteBookItemClickEvent();
        listenNoteBookItemLongClickEvent();
    }

    public void getData() {
        mNoteBookLiveData = LiveDataReactiveStreams.fromPublisher(mNoteBookRepository.getNotes()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread()));
    }

    public void saveData(String note) {
        if(mSelectedItem != null) {
            mNoteBookRepository.updateNotes(mSelectedItem.getId(), note);
        }else{
            mNoteBookRepository.saveNotes(note);
        }
    }

    public void deleteItem(long id) {
        AppDataBase.getAppDatabase().noteBookDao().delete(id);
    }

    public LiveData<List<Note>> getNoteBookLiveData() {
        return mNoteBookLiveData;
    }

    public Note getSelectedItem() {
        return mSelectedItem;
    }

    public void setSelectedItem(Note selectedItem) {
        mSelectedItem = selectedItem;
    }

    private void listenNoteBookItemLongClickEvent() {
        mRxBus.toObservable()
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>) o ->
                        o instanceof NavigationEvent && ((NavigationEvent) o).getFlag().equals(NavigationEvent.EVENT_ON_NOTE_BOOK_ITEM_LONG_CLICK))
                .cast(NavigationEvent.class)
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<NavigationEvent>) navigationEvent -> navigationEvent.getData() instanceof Note)
                .map(navigationEvent -> (Note) navigationEvent.getData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(note ->
                        deleteItem(note.getId()));
    }

    private void listenNoteBookItemClickEvent() {
        mRxBus.toObservable()
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<Object>) o ->
                        o instanceof NavigationEvent && ((NavigationEvent) o).getFlag().equals(NavigationEvent.EVENT_ON_NOTE_BOOK_ITEM_CLICK))
                .cast(NavigationEvent.class)
                .filter((AppendOnlyLinkedArrayList.NonThrowingPredicate<NavigationEvent>) navigationEvent -> navigationEvent.getData() instanceof Note)
                .map(navigationEvent -> (Note) navigationEvent.getData())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(note -> {
                    setSelectedItem(note);
                    mNavigator.launchNotePadScreen();
                });
    }

}
