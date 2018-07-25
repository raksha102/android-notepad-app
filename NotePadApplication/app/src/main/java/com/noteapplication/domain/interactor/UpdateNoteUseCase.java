package com.noteapplication.domain.interactor;


import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.domain.executor.PostExecutionThread;
import com.noteapplication.domain.executor.ThreadExecutor;

import javax.inject.Inject;

public class UpdateNoteUseCase extends UseCase<Boolean, UpdateNoteUseCase.Params> {

    private final NoteBookRepository mMapper;

    @Inject
    public UpdateNoteUseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread,
                             NoteBookRepository mapper) {
        super(threadExecutor, postExecutionThread);
        mMapper = mapper;
    }

    @Override
    public Boolean execute(Params params) {
        mMapper.updateNotes(params.id, params.note);
        return true;
    }

    public class Params {
        private long id;
        private String note;

        public Params(long id, String note) {
            this.id = id;
            this.note = note;
        }
    }
}
