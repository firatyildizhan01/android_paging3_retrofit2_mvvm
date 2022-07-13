package com.bersyte.paging3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bersyte.paging3.model.Events
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.model.SportModel
import com.bersyte.paging3.repository.SportRepository
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
