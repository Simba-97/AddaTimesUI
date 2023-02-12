package com.simba.addatimes.data

import com.simba.addatimes.data.models.OriginalResponse
import javax.inject.Inject

interface Repository {
    suspend fun getOriginals(): OriginalResponse
}

class DefaultRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : Repository {

    override suspend fun getOriginals(): OriginalResponse {
        return remoteDataSource.getOriginals()
    }

}