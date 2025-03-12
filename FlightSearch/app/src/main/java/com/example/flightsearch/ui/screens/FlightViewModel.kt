package com.example.flightsearch.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.ui.data.FlightDao
import com.example.flightsearch.ui.data.FlightDetailsCode
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class FlightViewModel(private val flightDao: FlightDao) : ViewModel() {

    fun getAvailableFights() {
        var result = emptyList<FlightDetailsCode>()
        viewModelScope.launch {
            result = flightDao.getAvailableFlights().first()
        }.invokeOnCompletion {
            Log.d(this.javaClass.simpleName, "Result: ${result.size}")
        }
    }

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