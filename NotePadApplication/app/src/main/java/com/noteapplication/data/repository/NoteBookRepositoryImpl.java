package com.noteapplication.data.repository;


import com.noteapplication.application.constants.AppConstants;
import com.noteapplication.data.datasource.CloudDataSource;
import com.noteapplication.data.datasource.DataBaseDataSource;
import com.noteapplication.data.datasource.MemoryDataSource;
import com.noteapplication.data.local.db.entity.NoteBookEntity;
import com.noteapplication.data.model.Note;
import com.noteapplication.data.model.mapper.Mapper;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * NoteBook repository is a data store for storing note data
 * Data can be pulled from cloud, database or/and from file system
 */
public class NoteBookRepositoryImpl implements NoteBookRepository {

    private final DataBaseDataSource mDatabaseDataSource;
    private final CloudDataSource mCloudDataSource;
    private final Mapper mMapper;
    private final MemoryDataSource mMemoryDataSource;
    private String mPolicy = AppConstants.POLICY_DATABASE;

    @Inject
    public NoteBookRepositoryImpl(DataBaseDataSource databaseDataSource, Mapper mapper,
                                  CloudDataSource cloudDataSource, MemoryDataSource memoryDataSource) {
        mDatabaseDataSource = databaseDataSource;
        mCloudDataSource = cloudDataSource;
        mMemoryDataSource = memoryDataSource;
        mMapper = mapper;
    }

    @Override
    public NoteBookRepository withPolicy(String cachePolicy) {
        mPolicy = cachePolicy;
        return this;
    }

    //Todo : create factory class
    @Override
    public Flowable<List<Note>> getNotes() {
        switch (mPolicy) {
            case AppConstants.POLICY_DATABASE:
                return mDatabaseDataSource.getNotes()
                        .flatMap(noteBookEntities -> Flowable.just(mMapper.transform(noteBookEntities)));
            case AppConstants.POLICY_NETWORK:
                return mCloudDataSource.getNotes()
                        .flatMap(notesResponse -> Flowable.just(mMapper.transform(notesResponse)));
            case AppConstants.POLICY_MEMORY:
                return mMemoryDataSource.getNotes()
                        .flatMap(noteBookEntities -> Flowable.just(mMapper.transform(noteBookEntities)));
            default:
                return mDatabaseDataSource.getNotes()
                        .flatMap(noteBookEntities -> Flowable.just(mMapper.transform(noteBookEntities)));
        }
    }

    @Override
    public void saveNotes(String note) {
        //Todo : save using policy specified
        mDatabaseDataSource.saveNotes(new NoteBookEntity(note));
    }

    @Override
    public void updateNotes(long id, String note) {
        mDatabaseDataSource.updateNotes(id, note);
    }
}
