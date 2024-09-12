package com.example.zmusic.data.repository

import com.example.zmusic.data.network.ApiInterface
import com.example.zmusic.domain.model.Top100Model
import com.example.zmusic.domain.repository.HomeRepository
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface
) : HomeRepository {
    override suspend fun getTop100(): List<Top100Model> {
        return apiInterface.getTop100();
    }
}