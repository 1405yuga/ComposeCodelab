package com.example.flightsearch.ui.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    @Query("SELECT departed.iata_code AS departureCode,destination.iata_code AS destinationCode from airport AS departed, airport AS destination WHERE departed.id!=destination.id")
    fun getAvailableFlights(): Flow<List<FlightDetailsCode>>
}