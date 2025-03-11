package com.example.busschedule.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bus_schedule")
data class BusSchedule(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val stopName: String,
    val arrivalTimeInMillis: Int
)
