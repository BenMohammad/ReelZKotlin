package com.benmohammad.reelzapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.benmohammad.reelzapp.data.repository.MainRepository
import com.benmohammad.reelzapp.ui.intent.MainIntent
import com.benmohammad.reelzapp.ui.viewstate.MainState
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repository: MainRepository): ViewModel() {

    val snippetIntent = Channel<MainIntent>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<MainState>(MainState.Idle)
    val state: StateFlow<MainState>
    get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            snippetIntent.consumeAsFlow().collect{
                when(it) {
                    is MainIntent.FetchOutput -> fetchOutput()
                }
            }
        }
    }

    private fun fetchOutput() {

    }
}