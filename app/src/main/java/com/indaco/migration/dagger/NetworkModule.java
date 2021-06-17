package com.indaco.migration.dagger;

import dagger.Module;

@Module
public class NetworkModule {

    private final String mBaseUrl;

    // Constructor needs one parameter to instantiate.
    public NetworkModule(String baseUrl) {
        mBaseUrl = baseUrl;
    }
}