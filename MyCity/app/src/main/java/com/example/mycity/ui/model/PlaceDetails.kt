package com.example.mycity.ui.model

import androidx.annotation.DrawableRes
import com.example.mycity.R

data class PlaceDetails(
    @DrawableRes val placeImage: Int,
    val placeName: String,
    val description: String,
    val isPetFriendly: Boolean
)

enum class Category(@DrawableRes val categoryImage: Int) {
    COFFEE_SHOPS(R.drawable.coffee_shop_24),
    RESTAURANTS(R.drawable.restaurant_24),
    PARKS(R.drawable.park_24),
    SHOPPING_CENTER(R.drawable.shopping_center_24),
    FORTS(R.drawable.fort_24),
    BEACHES(R.drawable.beach_24)
}