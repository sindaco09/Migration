package com.indaco.migration.dagger;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.room.Room;

import com.indaco.migration.data.repository.UserRepository;
import com.indaco.migration.data.storage.cache.UserCache;
import com.indaco.migration.room.AppDatabase;
import com.indaco.migration.data.storage.dao.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class StorageModule {

    // Application reference must come from AppModule.class
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return application.getSharedPreferences("prefs", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AppDatabase provideDb(Application application) {
        return Room.databaseBuilder(application,
                AppDatabase.class, "database")
                .fallbackToDestructiveMigration() //clear db on version increase
                .build();
    }

    @Provides
    @Singleton
    UserDao provideUserDao(AppDatabase appDatabase) {
        return appDatabase.provideMainDao();
    }

    @Provides
    @Singleton
    UserCache provideUserCache(SharedPreferences sp, UserDao userDao) {
        return new UserCache(userDao, sp);
    }

    @Provides
    @Singleton
    UserRepository providesMainRepository(UserCache userCache) {
        return new UserRepository(userCache);
    }
}