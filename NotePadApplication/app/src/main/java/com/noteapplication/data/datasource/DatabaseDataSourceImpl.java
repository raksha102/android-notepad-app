package com.noteapplication.data.datasource;


import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.injection.scope.ApplicationScope;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

@ApplicationScope
public class DatabaseDataSourceImpl implements DataBaseDataSource {

    @Inject
    public DatabaseDataSourceImpl() {

    }

    public Flowable<List<NoteBookEntity>> getNotes() {
        return AppDataBase.getAppDatabase().noteBookDao().getNoteBookData();
    }

    @Override
    public void saveNotes(NoteBookEntity noteBookEntity) {
        AppDataBase.getAppDatabase().noteBookDao().insert(noteBookEntity);
    }

    @Override
    public void updateNotes(long id, String note) {
        AppDataBase.getAppDatabase().noteBookDao().update(new NoteBookEntity(id, note));
    }

    @Override
    public void delete(long id) {
        AppDataBase.getAppDatabase().noteBookDao().delete(id);
    }
}
