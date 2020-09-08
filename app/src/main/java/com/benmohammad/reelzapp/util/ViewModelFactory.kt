package com.benmohammad.reelzapp.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.benmohammad.reelzapp.data.api.ApiHelper
import com.benmohammad.reelzapp.data.api.ApiHelperImpl
import com.benmohammad.reelzapp.data.repository.MainRepository
import com.benmohammad.reelzapp.ui.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown model Class...")
    }
}