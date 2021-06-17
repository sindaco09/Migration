package com.indaco.migration.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.indaco.migration.data.model.main.User;
import com.indaco.migration.data.storage.dao.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao provideMainDao();
//    public abstract LeaderboardDao leaderboardDao();
}
