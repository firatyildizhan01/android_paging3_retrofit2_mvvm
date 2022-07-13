package com.bersyte.paging3.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listmodel")
data class ListModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nameOne: String,
    val nameSecond: String,
    val rateOne: String,
    val rateTwo: String,
    val rateThird: String,
    val calendar: String,
    val finishTime: String,
    val imageOneUrl : String,
    val imageSecondUrl : String,
    val score : String
)
