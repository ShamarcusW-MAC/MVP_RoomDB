package com.example.week5_day1_mvp_roomdb.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Guests")
class GuestEntity(
    @PrimaryKey(autoGenerate = true) var guestID: Int?,
    @ColumnInfo(name = "guestName") val guestName: String,
    @ColumnInfo(name = "guestPrice") val guestPrice: Int) {

    constructor(guestName: String, guestPrice: Int) : this(null, guestName, guestPrice)
}