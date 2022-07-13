package com.sport.sportlike.api

import com.sport.sportlike.model.ResponseApi
import com.sport.sportlike.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET(Constants.END_POINT)
    suspend fun getAllSport(
    ): Response<ResponseApi>

    @Headers("Package: KlUet6y43te8Jg6G9bkDxN36f9X9ZiTkm")
    @GET("v1/event/{game_id}/list/live/en")
    suspend fun getSpecificSport(
        @Path("game_id") game_id: String
    ): Response<ResponseApi>
}