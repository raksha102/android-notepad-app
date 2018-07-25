package com.noteapplication.domain.interactor;


import com.noteapplication.data.model.Note;
import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.domain.executor.PostExecutionThread;
import com.noteapplication.domain.executor.ThreadExecutor;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

public class GetNoteBookUseCase extends UseCase<Flowable<List<Note>>, Void> {

    private final NoteBookRepository mMapper;

    @Inject
    public GetNoteBookUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                              NoteBookRepository mapper) {
        super(threadExecutor, postExecutionThread);
        mMapper = mapper;
    }

    @Override
    public Flowable<List<Note>> execute(Void params) {
        return mMapper.getNotes()
                .compose(getApiExecutor());
    }
}
