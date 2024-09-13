package com.example.zmusic.presentation.home

import com.example.zmusic.domain.model.Top100Model

data class Top100State(
    val isLoading: Boolean = false,
    val top100: List<Top100Model> = emptyList(),
    val error: String = ""
)
