package com.caps.rempasi.data.repository

import com.caps.rempasi.domain.repository.DataStoreRepository
import com.rijaldev.snapgram.data.source.local.datastore.AppPreferences
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataStoreRepositoryImpl @Inject constructor(
    private val appPreferences: AppPreferences,
) : DataStoreRepository {
    override suspend fun saveOnBoardingState(completed: Boolean) = appPreferences.saveOnBoardingState(completed)

    override fun readOnBoardingState(): Flow<Boolean> = appPreferences.readOnBoardingState()
}