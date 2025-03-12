package com.example.flightsearch.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.ui.data.FlightDao
import com.example.flightsearch.ui.data.FlightDetails
import kotlinx.coroutines.flow.Flow

class FlightViewModel(private val flightDao: FlightDao) : ViewModel() {

    fun getAvailableFights(): Flow<List<FlightDetails>> = flightDao.getAvailableFlights()

    init {
        getAvailableFights()
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                FlightViewModel(application.database.flightDao())
            }
        }
    }
}