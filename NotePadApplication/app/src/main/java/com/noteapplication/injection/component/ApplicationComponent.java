
package com.noteapplication.injection.component;

import android.app.Application;

import com.noteapplication.application.NoteBookApplication;
import com.noteapplication.injection.module.ActivityBuilder;
import com.noteapplication.injection.module.ApplicationModule;
import com.noteapplication.injection.module.NetworkModule;
import com.noteapplication.injection.scope.ApplicationScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class, ApplicationModule.class,
        NetworkModule.class})
public interface ApplicationComponent {

    void inject(NoteBookApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

}
