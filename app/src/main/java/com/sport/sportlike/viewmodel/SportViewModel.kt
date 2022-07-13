package com.sport.sportlike.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.model.SportModel
import com.sport.sportlike.repository.SportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SportViewModel
@Inject
constructor(private val sportRepository: SportRepository) : ViewModel() {

    fun insertSport(sport: SportModel) = viewModelScope.launch {
        sportRepository.insertSport(sport) }

    fun deleteSport(sport: SportModel) = viewModelScope.launch {
        sportRepository.deleteSport(sport)}

    val allSport = sportRepository.getAllToDo().asLiveData()

    fun insertEvents(list: ListModel) = viewModelScope.launch {
        sportRepository.insertEvent(list) }

    fun deleteEvents(list: ListModel) = viewModelScope.launch {
        sportRepository.deleteEvent(list)}

    val allEvents = sportRepository.getAllEvent().asLiveData()
}
