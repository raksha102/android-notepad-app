package com.noteapplication.injection.module;

import com.noteapplication.data.datasource.CloudDataSource;
import com.noteapplication.data.datasource.CloudDataSourceImpl;
import com.noteapplication.data.datasource.DataBaseDataSource;
import com.noteapplication.data.datasource.DatabaseDataSourceImpl;
import com.noteapplication.data.datasource.MemoryDataSource;
import com.noteapplication.data.datasource.MemoryDataSourceImpl;
import com.noteapplication.data.model.mapper.Mapper;
import com.noteapplication.data.model.mapper.NoteBookMapper;
import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.data.repository.NoteBookRepositoryImpl;
import com.noteapplication.injection.scope.ApplicationScope;

import dagger.Binds;
import dagger.Module;

@Module(includes = {NetworkSubModule.class})
public abstract class NetworkModule {

    @Binds
    @ApplicationScope
    public abstract CloudDataSource provideCloudDataSource(CloudDataSourceImpl cloudDataSource);

    @Binds
    @ApplicationScope
    public abstract DataBaseDataSource provideDatabaseDataSource(DatabaseDataSourceImpl dataSource);

    @Binds
    @ApplicationScope
    public abstract Mapper provideMapper(NoteBookMapper mapper);

    @Binds
    @ApplicationScope
    public abstract MemoryDataSource provideMemoryDataSource(MemoryDataSourceImpl memoryDataSource);

    @Binds
    @ApplicationScope
    public abstract NoteBookRepository provideNoteBookRepository(NoteBookRepositoryImpl noteBookRepository);
}
