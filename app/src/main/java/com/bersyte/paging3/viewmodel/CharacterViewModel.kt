package com.bersyte.paging3.viewmodel

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.bersyte.paging3.api.ApiService
import com.bersyte.paging3.model.ResponseApi
import com.bersyte.paging3.repository.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel
@Inject
constructor(private val repository: ApiRepository) : ViewModel() {

    private val _response = MutableLiveData<ResponseApi>()
    private val _responseAll = MutableLiveData<ResponseApi>()
    val sportResponse: LiveData<ResponseApi> = _response

    init {
        getSpors()
    }

    private fun getSpors() = viewModelScope.launch {
        repository.getSpors().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }

    private fun getSpecificSport(game_id : String) = viewModelScope.launch {
        repository.getSpecificSport(game_id).let { response ->

            if (response.isSuccessful) {
                _responseAll.postValue(response.body())
            } else {
                Log.d("tag", "getWeather Error: ${response.code()}")
            }
        }
    }
}