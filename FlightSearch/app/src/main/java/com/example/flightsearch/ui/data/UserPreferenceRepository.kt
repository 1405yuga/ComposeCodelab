package com.example.flightsearch.ui.data

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class UserPreferenceRepository(private val dataStore: DataStore<Preferences>) {
    private companion object {
        val SEARCHED_QUERY = stringPreferencesKey("searched_query")
    }

    suspend fun saveSearchedQuery(query: String) {
        dataStore.edit { preferences ->
            preferences[SEARCHED_QUERY] = query
        }
    }

    val searchedQuery: Flow<String> = dataStore.data
        .catch {
            if (it is IOException) {
                Log.e(this.javaClass.simpleName, "Error reading preference.", it)
                emit(emptyPreferences())
            } else {
                throw it
            }
        }
        .map { preferences ->
            preferences[SEARCHED_QUERY] ?: ""
        }

}