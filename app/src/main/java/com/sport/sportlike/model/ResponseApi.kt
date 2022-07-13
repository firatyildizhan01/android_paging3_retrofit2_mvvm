package com.sport.sportlike.model

data class ResponseApi(
    val body: List<Body>,
    val page: String,
    val status: Int
)