package com.sport.sportlike.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
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
    val score : String,
    val gameid : String,
): Parcelable
