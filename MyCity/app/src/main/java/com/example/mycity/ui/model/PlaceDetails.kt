package com.example.mycity.ui.model

data class PlaceDetails(
    val placeName: String,
    val description: String,
    val isPetFriendly: Boolean
)

enum class Category {
    COFFEE_SHOPS, RESTAURANTS, PARKS, SHOPPING_CENTER, FORTS, BEACHES
}