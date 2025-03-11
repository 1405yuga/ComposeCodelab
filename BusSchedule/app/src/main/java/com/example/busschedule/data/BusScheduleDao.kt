package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * FROM bus_schedule ORDER BY arrivalTimeInMillis ASC")
    fun getAllBusSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * from bus_schedule WHERE stopName= :stopName ORDER BY arrivalTimeInMillis ASC")
    fun getBusScheduleByBusStop(stopName: String): Flow<List<BusSchedule>>
}