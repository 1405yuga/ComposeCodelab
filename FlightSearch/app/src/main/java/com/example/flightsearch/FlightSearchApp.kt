package com.example.flightsearch

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightsearch.ui.screens.FlightTopAppBar
import com.example.flightsearch.ui.screens.HomeScreen

@Composable
fun FlightSearchApp() {
    Scaffold(
        topBar = {
            FlightTopAppBar()
        }
    ) { innerPadding ->
        HomeScreen(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        )
    }
}


@Composable
@Preview
fun FlightSearchAppPreview() {
    FlightSearchApp()
}