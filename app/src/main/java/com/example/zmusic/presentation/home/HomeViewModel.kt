package com.example.zmusic.presentation.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zmusic.common.Resources
import com.example.zmusic.domain.use_case.GetTop100UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTop100UseCase: GetTop100UseCase
) : ViewModel() {
    private val _top100State = mutableStateOf(Top100State())
    val top100State: State<Top100State> = _top100State

    init {
        getTop100()
    }

    private fun getTop100() {
        getTop100UseCase().onEach { result ->
            when (result) {
                is Resources.Success -> {
                    _top100State.value = Top100State(top100 = result.data ?: emptyList())
                }

                is Resources.Error -> {
                    _top100State.value =
                        Top100State(error = result.message ?: "An unexpected error occurred")
                }

                is Resources.Loading -> {
                    _top100State.value = Top100State(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}