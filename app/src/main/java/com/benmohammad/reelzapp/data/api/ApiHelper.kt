package com.benmohammad.reelzapp.data.api

import com.benmohammad.reelzapp.data.model.PostData

interface ApiHelper {

    suspend fun getOutput(postData: PostData) : String
}