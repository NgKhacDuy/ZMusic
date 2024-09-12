package com.example.zmusic.data.network

import com.example.zmusic.domain.model.Top100Model
import retrofit2.http.GET

interface ApiInterface {
    @GET("api/top100")
    suspend fun getTop100(): List<Top100Model>
}