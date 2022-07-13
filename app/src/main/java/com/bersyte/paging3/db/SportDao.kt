package com.bersyte.paging3.db

import androidx.room.*
import com.bersyte.paging3.model.Events
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.model.SportModel
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