package com.benmohammad.reelzapp.data.model

data class PostData(
    val clientId: String,
    val clientSecret: String,
    val script: String,
    val language: String,
    val versionIndex: String
)