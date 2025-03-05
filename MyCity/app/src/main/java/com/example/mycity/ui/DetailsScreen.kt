package com.example.mycity.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycity.R
import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category
import com.example.mycity.ui.model.PlaceDetails

@Composable
fun DetailsScreen(
    placeDetails: PlaceDetails?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    placeDetails?.let {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(vertical = 8.dp, horizontal = 12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = it.placeName,
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier.weight(1f)) {
                Text(
                    text = it.placeName,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 32.sp
                )
                Text(text = it.description)
                Text(text = "Pets are ${if (it.isPetFriendly) "" else "not"} allowed")
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
fun DetailsScreenPreview() {
    DetailsScreen(
        placeDetails = PlacesData.getPlaceDetails(Category.COFFEE_SHOPS,0),
        onClick = {}
    )
//    DetailsScreen(null)

}