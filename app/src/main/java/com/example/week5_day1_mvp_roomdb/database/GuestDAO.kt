package com.example.week5_day1_mvp_roomdb.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GuestDAO {


    @Insert
    fun addNewGuest(guestEntity: GuestEntity)

    @Query("SELECT * FROM Guests")
    fun retrieveAllGuests(): List<GuestEntity>

    @Delete
    fun deleteFromGuests(guestEntity: GuestEntity)
}