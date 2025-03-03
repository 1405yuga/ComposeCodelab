package com.example.dessertclicker.data

import androidx.annotation.DrawableRes

data class DessertUiState(
    val currentDessertIndex: Int = 0,
    val dessertSold: Int = 0,
    val revenue: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImage: Int = Datasource.dessertList[currentDessertIndex].imageId
)
