package com.example.zmusic.domain.repository

import com.example.zmusic.domain.model.Top100Model

interface HomeRepository {
    suspend fun getTop100(): List<Top100Model>
}