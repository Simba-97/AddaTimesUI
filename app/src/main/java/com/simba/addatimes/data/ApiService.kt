package com.simba.addatimes.data

import com.simba.addatimes.data.models.OriginalResponse
import com.simba.addatimes.utils.ApiEndpoint
import retrofit2.http.GET

interface ApiService {

    @GET(ApiEndpoint.ENDPOINT_MOBILE)
    suspend fun getOriginalsData(): OriginalResponse
}