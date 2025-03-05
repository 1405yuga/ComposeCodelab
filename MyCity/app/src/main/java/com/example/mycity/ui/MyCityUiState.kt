package com.example.mycity.ui

import com.example.mycity.ui.data.PlacesData
import com.example.mycity.ui.model.Category
import com.example.mycity.ui.model.PlaceDetails

data class MyCityUiState(
    val categorySelected: Category = Category.COFFEE_SHOPS,
    val placeSelected: PlaceDetails = PlacesData.getBlankPlaceDetail()
)
