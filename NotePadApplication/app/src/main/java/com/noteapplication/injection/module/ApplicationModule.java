package com.noteapplication.injection.module;

import com.noteapplication.data.manager.SessionManager;
import com.noteapplication.data.manager.SessionManagerService;
import com.noteapplication.injection.scope.ApplicationScope;
import com.noteapplication.ui.base.rxbus.RxBus;
import com.noteapplication.ui.base.rxbus.RxBusImpl;
import com.noteapplication.util.IKeyBoardUtil;
import com.noteapplication.util.KeyBoardUtil;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ApplicationModule {

    @Binds
    @ApplicationScope
    public abstract RxBus provideRxBus(RxBusImpl rxBus);

    @Binds
    @ApplicationScope
    public abstract IKeyBoardUtil provideKeyBoardUtil(KeyBoardUtil keyBoardUtil);

    @Binds
    @ApplicationScope
    public abstract SessionManagerService provideSessionManagerService(SessionManager sessionManager);
}
