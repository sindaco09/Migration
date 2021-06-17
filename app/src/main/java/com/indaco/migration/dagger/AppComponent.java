package com.indaco.migration.dagger;

import com.indaco.migration.ui.screens.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class
                , NetworkModule.class
                , StorageModule.class
        }
)

public interface AppComponent {
    void inject(MainActivity activity);
}