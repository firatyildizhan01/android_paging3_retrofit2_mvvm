package com.sport.sportlike.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sportmodel")
data class SportModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val sportTitle: String
)
