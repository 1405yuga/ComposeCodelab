package com.example.mycity.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.R
import com.example.mycity.ui.data.PlacesData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.app_name)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        MyCityHomeScreen(modifier = Modifier.padding(innerPadding))

    }
}

@Composable
fun MyCityHomeScreen(modifier: Modifier = Modifier) {
    val categoryListInPair = PlacesData.getAllCategoryInPair()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ItemsList(imageAndTitleList = categoryListInPair)
    }
}

@Composable
@Preview
fun MyCityScreenPreview() {
    MyCityApp()
}

@Composable
@Preview
fun ItemsListPreview() {
    ItemsList(imageAndTitleList = PlacesData.getAllCategoryInPair())
}