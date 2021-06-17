package com.indaco.migration.data.repository

import com.indaco.migration.data.storage.cache.UserCache
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val userCache: UserCache
) {
}