package com.example.flightsearch.ui.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AirportDetails::class, Favorite::class], version = 1, exportSchema = false)
abstract class FlightDatabase : RoomDatabase() {
    abstract fun flightDao(): FlightDao

    companion object {
        private var INSTANCE: FlightDatabase? = null

        fun getDatabase(context: Context): FlightDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(context, FlightDatabase::class.java, "airport_database")
                    .fallbackToDestructiveMigration()
                    .createFromAsset("flight_search.db")
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}