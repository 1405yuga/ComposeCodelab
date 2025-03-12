package com.example.dessertrelease.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit

class UserPreferenceRepository(private val dataStore: DataStore<Preferences>) {
    private companion object {
        val IS_LINEAR_LAYOUT = booleanPreferencesKey("is_linear_layout")
    }

    suspend fun saveLayoutPreference(isLinearLayout: Boolean) {
        dataStore.edit { preferences ->
            preferences[IS_LINEAR_LAYOUT] = isLinearLayout
        }
    }
}