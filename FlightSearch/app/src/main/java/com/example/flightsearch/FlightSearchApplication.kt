package com.example.flightsearch

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.example.flightsearch.ui.data.FlightDatabase
import com.example.flightsearch.ui.data.UserPreferenceRepository

private const val PREFERENCE_NAME = "searched_query"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = PREFERENCE_NAME
)

class FlightSearchApplication : Application() {
    val database: FlightDatabase by lazy { FlightDatabase.getDatabase(this) }
    lateinit var userPreferenceRepository: UserPreferenceRepository
    override fun onCreate() {
        super.onCreate()
        userPreferenceRepository = UserPreferenceRepository(dataStore)
    }
}