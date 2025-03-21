package com.example.flightsearch.ui.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    @Query(
        """
    SELECT 
        departed.iata_code AS departureCode,
        departed.name AS departureName,
        destination.iata_code AS destinationCode,
        destination.name AS destinationName,
        CASE WHEN f.id IS NOT NULL THEN 1 ELSE 0 END AS isFavorite
    FROM airport AS departed
    CROSS JOIN airport AS destination
    LEFT JOIN Favorite f 
        ON f.departure_code = departed.iata_code 
        AND f.destination_code = destination.iata_code
    WHERE departed.id != destination.id
    """
    )
    fun getAvailableFlights(): Flow<List<FlightDetails>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToFavorite(favorite: Favorite)

    @Query("SELECT COUNT(*) FROM Favorite WHERE departure_code = :departureCode AND destination_code = :destinationCode")
    suspend fun isFlightFavorite(departureCode: String, destinationCode: String): Int

    @Query(
        """
      SELECT f.departure_code AS departureCode,
      dep.name AS departureName,
      f.destination_code AS destinationCode,
      dest.name AS destinationName,
      1 AS isFavorite
      FROM Favorite f
      JOIN airport dep ON f.departure_code = dep.iata_code
      JOIN airport dest ON f.destination_code = dest.iata_code
    """
    )
    fun getAllFavoriteFlights(): Flow<List<FlightDetails>>

    @Query("DELETE FROM Favorite WHERE departure_code= :departureCode AND destination_code= :destinationCode")
    suspend fun deleteFromFavorite(departureCode: String, destinationCode: String)
}
