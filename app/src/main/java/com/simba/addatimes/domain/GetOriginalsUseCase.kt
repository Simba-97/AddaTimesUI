package com.simba.addatimes.domain

import com.simba.addatimes.data.Repository
import com.simba.addatimes.data.models.OriginalResponse
import com.simba.addatimes.di.component.IoDispatcher
import com.simba.addatimes.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetOriginalsUseCase @Inject constructor(
    private val repository: Repository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, OriginalResponse>(ioDispatcher) {
    override suspend fun execute(parameter: Unit): OriginalResponse {
        return repository.getOriginals()
    }
}