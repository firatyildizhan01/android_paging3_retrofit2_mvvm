package com.bersyte.paging3.model

data class ResponseApi(
    val body: List<Body>,
    val page: String,
    val status: Int
)