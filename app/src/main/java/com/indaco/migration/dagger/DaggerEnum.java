package com.indaco.migration.dagger;

import com.indaco.migration.App;

public enum DaggerEnum {
    instance;

    private AppComponent appComponent;

    public void setupDagger() {
        // Dagger%COMPONENT_NAME%
        appComponent = DaggerAppComponent.builder()
                // list of modules that are part of this component need to be created
                .appModule(new AppModule(App.sInstance))
                .networkModule(new NetworkModule("www.google.com"))
                .storageModule(new StorageModule())
                .build();
    }

    public AppComponent getAppComponent() {
        if(appComponent==null) {
            setupDagger();
        }
        return appComponent;
    }
}

