package com.example.flightsearch.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearch.FlightSearchApplication
import com.example.flightsearch.ui.data.Favorite
import com.example.flightsearch.ui.data.FlightDao
import com.example.flightsearch.ui.data.FlightDetails
import com.example.flightsearch.ui.data.UserPreferenceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class FlightViewModel(
    private val flightDao: FlightDao,
    private val userPreferenceRepository: UserPreferenceRepository
) : ViewModel() {

    fun setQuery(query: String) {
        viewModelScope.launch {
            userPreferenceRepository.saveSearchedQuery(query)
        }
    }

    val searchQuery: Flow<String> = userPreferenceRepository.searchedQuery

    fun getAvailableFights(): Flow<List<FlightDetails>> =
        flightDao.getAvailableFlights()

    fun getFavoriteFlights(): Flow<List<FlightDetails>> = flightDao.getAllFavoriteFlights()

    suspend fun addToFavorite(flightDetails: FlightDetails) {
        if (flightDao.isFlightFavorite(
                departureCode = flightDetails.departureCode,
                destinationCode = flightDetails.destinationCode
            ) < 1
        ) {
            flightDao.insertToFavorite(flightDetails.toFavorite())
        }
    }

    suspend fun removeFromFavorite(flightDetails: FlightDetails) {
        flightDao.deleteFromFavorite(
            departureCode = flightDetails.departureCode,
            destinationCode = flightDetails.destinationCode
        )
    }

    init {
        getAvailableFights()
    }

    companion object {
        val factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                FlightViewModel(
                    application.database.flightDao(),
                    application.userPreferenceRepository
                )
            }
        }
    }
}

fun FlightDetails.toFavorite(): Favorite {
    return Favorite(
        id = 0,
        departureCode = this.departureCode,
        destinationCode = this.destinationCode
    )
}