package com.noteapplication.data.repository;


import com.noteapplication.application.constants.AppConstants;
import com.noteapplication.data.datasource.CloudDataSource;
import com.noteapplication.data.datasource.DataBaseDataSource;
import com.noteapplication.data.datasource.DatabaseDataSourceImpl;
import com.noteapplication.data.local.db.AppDataBase;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.model.mapper.NoteBookMapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class NoteBookRepositoryImpl implements NoteBookRepository {

    private final DataBaseDataSource mDatabaseDataSource;
    private final CloudDataSource mCloudDataSource;
    private final NoteBookMapper mMapper;
    private String mPolicy;

    @Inject
    public NoteBookRepositoryImpl(DataBaseDataSource databaseDataSource, CloudDataSource cloudDataSource,
                                  NoteBookMapper mapper) {
        mDatabaseDataSource = databaseDataSource;
        mCloudDataSource = cloudDataSource;
        mMapper = mapper;
    }

    @Override
    public NoteBookRepository withPolicy(String cachePolicy) {
        mPolicy = cachePolicy;
        return this;
    }

    @Override
    public Flowable<List<Note>> getNotes() {
        switch (mPolicy) {
            case AppConstants.POLICY_DATABASE:
                return AppDataBase.getAppDatabase().noteBookDao().getNoteBookData()
                        .flatMap(noteBookEntities -> Flowable.just(mMapper.transform(noteBookEntities)));
            case AppConstants.POLICY_NETWORK:
                return mCloudDataSource.getNotes()
                        .flatMap(notesResponse -> Flowable.just(mMapper.transform(notesResponse)));
            default:
                return AppDataBase.getAppDatabase().noteBookDao().getNoteBookData()
                        .flatMap(noteBookEntities -> Flowable.just(mMapper.transform(noteBookEntities)));
        }

    }
}
