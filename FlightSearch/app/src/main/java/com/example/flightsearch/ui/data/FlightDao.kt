package com.example.flightsearch.ui.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    @Query( """
SELECT 
        departed.iata_code AS departureCode,
        departed.name AS departureName,
        destination.iata_code AS destinationCode ,
        destination.name AS destinationName
from airport AS departed, airport AS destination WHERE departed.id!=destination.id
"""
    )
    fun getAvailableFlights(): Flow<List<FlightDetails>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToFavorite(favorite: Favorite)

    @Query("""
      SELECT f.departure_code AS departureCode,
      dep.name AS departureName,
      f.destination_code AS destinationCode,
      dest.name AS destinationName
      FROM Favorite f
      JOIN airport dep ON f.departure_code = dep.iata_code
      JOIN airport dest ON f.destination_code = dest.iata_code
    """)
    fun getAllFavoriteFlights():Flow<List<FlightDetails>>
}
