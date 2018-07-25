package com.noteapplication;

import com.noteapplication.data.repository.NoteBookRepository;
import com.noteapplication.ui.base.navigator.AppNavigator;
import com.noteapplication.ui.base.rxbus.RxBus;
import com.noteapplication.ui.model.view.NoteBookViewModel;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class NoteBookViewModelUnitTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    NoteBookRepository mNoteBookRepository;

    @Mock
    AppNavigator mNavigator;

    @Mock
    RxBus mRxBus;

    NoteBookViewModel mViewModel;

    @Before
    public void setUp(){
        mViewModel = new NoteBookViewModel(mNoteBookRepository, mNavigator, mRxBus);
    }

    @Test
    public void testSaveData() throws Exception {
        mViewModel.saveData("test");
        verify(mNoteBookRepository).saveNotes("test");
    }

    @Test
    public void testDeleteData() throws Exception {
        mViewModel.deleteItem(101);
        verify(mNoteBookRepository).delete(101);
    }
}