package com.benmohammad.reelzapp.data.api

import com.benmohammad.reelzapp.data.model.PostData

class ApiHelperImpl(private val apiService: ApiService): ApiHelper {

    override suspend fun getOutput(postData: PostData): String {
        return apiService.fetchCompilation(postData.clientId, postData.clientSecret, postData.script,  postData.language, postData.versionIndex);
    }
}