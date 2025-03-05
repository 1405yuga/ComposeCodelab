package com.example.mycity.ui

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mycity.R
import com.example.mycity.ui.data.PlacesData

@Composable
fun MyCityHomeScreen(
    modifier: Modifier=Modifier
) {

//    Scaffold(
//        topBar =
//    ) {
//    }
}

@Composable
@Preview
fun MyCityScreenPreview() {
    ItemCard(R.drawable.ic_launcher_foreground, title = "Hello world")
}

@Composable
@Preview
fun ItemsListPreview() {
    ItemsList(imageAndTitleList = PlacesData.getAllCategoryInPair())
}