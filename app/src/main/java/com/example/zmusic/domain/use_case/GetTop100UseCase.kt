package com.example.zmusic.domain.use_case

import com.example.zmusic.domain.repository.HomeRepository
import com.example.zmusic.common.Resources
import com.example.zmusic.domain.model.Top100Model
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class GetTop100UseCase @Inject constructor(
    private val homeRepository: HomeRepository
) {
    operator fun invoke(): Flow<Resources<List<Top100Model>>> = flow {
        try {
            emit(Resources.Loading())
            val top100 = homeRepository.getTop100()
            emit(Resources.Success(top100))
        } catch (e: HttpException) {
            emit(Resources.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: Exception) {
            emit(Resources.Error(e.message ?: "An unexpected error occurred"))
        }
    }
}