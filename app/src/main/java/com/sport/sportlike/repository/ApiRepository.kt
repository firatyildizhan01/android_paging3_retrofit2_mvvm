package com.sport.sportlike.repository

import com.sport.sportlike.api.ApiService
import javax.inject.Inject

class ApiRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getSpors() = apiService.getAllSport()
    suspend fun getSpecificSport(game_id : String) = apiService.getSpecificSport(game_id)
}