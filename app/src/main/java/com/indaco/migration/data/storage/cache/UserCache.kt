package com.indaco.migration.data.storage.cache

import android.content.SharedPreferences
import com.indaco.migration.data.storage.dao.UserDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserCache @Inject constructor(
    private val userDao: UserDao,
    private val sp: SharedPreferences
    ) {
}