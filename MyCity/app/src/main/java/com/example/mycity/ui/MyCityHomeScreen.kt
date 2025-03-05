package com.example.mycity.ui

import androidx.annotation.StringRes
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.R
import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    viewModel: MyCityViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
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
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            startDestination = MyCityScreen.Home.name
        ) {
            composable(route = MyCityScreen.Home.name) {
                MyCityHomeScreen(
                    onClick = { categoryName ->
                        viewModel.setCategory(Category.valueOf(categoryName))
                        navController.navigate(MyCityScreen.RecommendationList.name)
                    },
                    modifier = Modifier
                )
            }
            composable(route = MyCityScreen.RecommendationList.name) {
                RecommendationListScreen(
                    placeNamesList = PlacesData.getPlacesInImageAndTitleByCategory(
                        uiState.categorySelected
                    ),
                    onClick = {
                        viewModel.setPlaceDetailsByIndex(it)
                        navController.navigate(MyCityScreen.DetailsScreen.name)
                    }
                )
            }
            composable(route = MyCityScreen.DetailsScreen.name) {
                DetailsScreen(
                    placeDetails = uiState.placeSelected,
                    onClick = { navController.navigate(MyCityScreen.Home.name) }
                )
            }
        }
    }
}

@Composable
fun MyCityHomeScreen(
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryListInPair = PlacesData.getAllCategoryInPair()
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ItemsList(
            imageAndTitleList = categoryListInPair,
            onItemClick = {
                onClick(it)
            }
        )
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
    ItemsList(imageAndTitleList = PlacesData.getAllCategoryInPair(),
        onItemClick = {})
}

enum class MyCityScreen(@StringRes val title: Int) {
    Home(R.string.app_name),
    RecommendationList(R.string.recommendation_screen),
    DetailsScreen(R.string.detail_screen)
}