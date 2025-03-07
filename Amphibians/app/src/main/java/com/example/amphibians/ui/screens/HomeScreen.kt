package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    amphibianUiState: AmphibianUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    Surface(
        modifier = modifier
            .fillMaxSize()
            .padding(contentPadding)
    ) {
        when (amphibianUiState) {
            is AmphibianUiState.Success -> Text("Hello")
            is AmphibianUiState.Error -> ErrorScreen()
            is AmphibianUiState.Loading -> LoadingScreen()
        }
    }

}