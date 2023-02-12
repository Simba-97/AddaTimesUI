package com.simba.addatimes.data

import com.simba.addatimes.data.models.OriginalResponse

interface RemoteDataSource {
    suspend fun getOriginals(): OriginalResponse
}

class DefaultRemoteDataSource(
    private val apiService: ApiService
) : RemoteDataSource {
    override suspend fun getOriginals(): OriginalResponse {
        return apiService.getOriginalsData()
    }
}