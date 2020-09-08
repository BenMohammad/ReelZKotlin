package com.benmohammad.reelzapp.ui.viewstate

sealed class MainState {

    object Idle: MainState()
    object Loading: MainState()
    data class Snippets(val output: String): MainState()
    data class Error(val error: String?): MainState()
}