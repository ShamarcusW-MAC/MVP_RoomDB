package com.example.week5_day1_mvp_roomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(version = 1, entities = [GuestEntity::class])
abstract class GuestDatabase: RoomDatabase() {
    abstract fun guestDAO(): GuestDAO
}