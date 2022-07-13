package com.bersyte.paging3.repository

import com.bersyte.paging3.db.SportDao
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.model.SportModel
import javax.inject.Inject

class SportRepository
@Inject
constructor(private val sportDao: SportDao) {

    suspend fun insertSport(sport: SportModel) = sportDao.insertToDo(sport)

    suspend fun deleteSport(sport: SportModel) = sportDao.deleteToDo(sport)

    fun getAllToDo() = sportDao.getAllToDos()

    suspend fun insertEvent(list: ListModel) = sportDao.insertAllSport(list)

    suspend fun deleteEvent(list: ListModel) = sportDao.deleteSport(list)

    fun getAllEvent() = sportDao.getAllSport()
}