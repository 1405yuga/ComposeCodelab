package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAllBusSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * from schedule WHERE stop_name= :stopName ORDER BY arrival_time ASC")
    fun getBusScheduleByBusStop(stopName: String): Flow<List<BusSchedule>>
}