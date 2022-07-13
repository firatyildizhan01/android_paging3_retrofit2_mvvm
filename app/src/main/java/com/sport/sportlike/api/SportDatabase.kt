package com.sport.sportlike.api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sport.sportlike.db.SportDao
import com.sport.sportlike.model.ListModel
import com.sport.sportlike.model.SportModel

@Database(
    entities = [SportModel::class, ListModel::class],
    version = 1, exportSchema = false
)
abstract class SportDatabase : RoomDatabase() {

    abstract fun sportDao(): SportDao

}