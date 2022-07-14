package com.sport.sportlike.repository

import com.sport.sportlike.db.SportDao
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.model.SportModel
import javax.inject.Inject

class SportRepository
@Inject
constructor(private val sportDao: SportDao) {

    suspend fun insertSport(sport: SportModel) = sportDao.insertToDo(sport)

    suspend fun deleteSport(sport: SportModel) = sportDao.deleteToDo(sport)

    fun getAllToDo() = sportDao.getAllToDos()

    suspend fun insertEvent(list: ListModel) = sportDao.insertAllSport(list)

    suspend fun updateEvent(id : Int, score : String){
        sportDao.updateEvent(id,score)
    }

    suspend fun deleteEvent(list: ListModel) = sportDao.deleteSport(list)

    fun getAllEvent() = sportDao.getAllSport()
}