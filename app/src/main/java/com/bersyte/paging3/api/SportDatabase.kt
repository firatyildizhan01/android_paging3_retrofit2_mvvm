package com.bersyte.paging3.api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bersyte.paging3.db.SportDao
import com.bersyte.paging3.model.Events
import com.bersyte.paging3.model.ListModel
import com.bersyte.paging3.model.SportModel

@Database(
    entities = [SportModel::class, ListModel::class],
    version = 1, exportSchema = false
)
abstract class SportDatabase : RoomDatabase() {

    abstract fun sportDao(): SportDao

}