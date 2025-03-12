package com.example.flightsearch.ui.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airport")
data class AirportDetails(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "iata_code")
    val iataCode: String,
    val name: String,
    val passengers: Long
)

@Entity(tableName = "favorite")
data class FlightDetailsCode(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo("departure_code")
    val departureCode: String,
    @ColumnInfo("destination_code")
    val destinationCode: String
)

data class FlightDetails(
    val id: Int,
    val departureCode: String,
    val departureName: String,
    val destinationCode: String,
    val destinationName: String
)