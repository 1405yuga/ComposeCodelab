package com.example.flightsearch

import android.app.Application
import com.example.flightsearch.ui.data.FlightDatabase

class FlightSearchApplication : Application() {
    val database: FlightDatabase by lazy { FlightDatabase.getDatabase(this) }
}