package com.sport.sportlike.db

import androidx.room.*
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.model.SportModel
import kotlinx.coroutines.flow.Flow

@Dao
interface SportDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(sport: SportModel)

    @Delete
    suspend fun deleteToDo(sport: SportModel)

    @Query("SELECT * FROM sportmodel ORDER BY sportTitle ASC ")
    fun getAllToDos(): Flow<List<SportModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllSport(list: ListModel)

    @Delete
    suspend fun deleteSport(list: ListModel)

    @Query("SELECT * FROM listmodel ORDER BY id ASC ")
    fun getAllSport(): Flow<List<ListModel>>
}