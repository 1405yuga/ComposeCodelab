package com.example.mycity.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category

@Composable
fun RecommendationListScreen(
    placeNamesList: List<Pair<Int, String>>?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        placeNamesList?.let {
            ItemsList(
                imageAndTitleList = placeNamesList,
                onItemClick = {onClick()}
            )
        } ?: Text(
            "Cannot load this category,\n please check!",
            fontSize = 22.sp,
        )
    }
}

@Composable
@Preview
fun RecommendationListScreenPreview() {
    RecommendationListScreen(
        PlacesData.getPlacesInImageAndTitleByCategory(Category.COFFEE_SHOPS),
        onClick = {}
    )
}