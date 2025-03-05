package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category
import com.example.mycity.ui.model.PlaceDetails

@Composable
fun RecommendationListScreen(
    placeNamesList: List<PlaceDetails>?,
    modifier: Modifier = Modifier
) {
    placeNamesList?.let {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(it) { (placeName) ->
                RecommendationCard(
                    placeName = placeName,
                    placeImage = R.drawable.ic_launcher_background
                )
            }
        }
    } ?: Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "Cannot load this category,\n please check!",
            fontSize = 22.sp,
        )
    }
}

@Composable
@Preview
fun RecommendationListScreenPreview() {
    RecommendationListScreen(
        PlacesData.getPlaceDetailsListByCategory(Category.COFFEE_SHOPS)
    )
}

@Composable
fun RecommendationCard(
    placeImage: Int,
    placeName: String,
    modifier: Modifier = Modifier
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(placeImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.padding(end = 8.dp)
        )
        Text(
            text = placeName,
            modifier = modifier
                .weight(1f)
                .padding(4.dp),
            fontSize = 22.sp
        )
    }
}

@Composable
@Preview
fun RecommendationCardPreview() {
    RecommendationCard(R.drawable.ic_launcher_background, "Merwans")
}