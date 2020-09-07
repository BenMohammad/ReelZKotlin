package com.benmohammad.reelzapp.data.repository

import com.benmohammad.reelzapp.data.api.ApiHelper
import com.benmohammad.reelzapp.data.model.PostData

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getOutput(postData: PostData) = apiHelper.getOutput(postData)
}