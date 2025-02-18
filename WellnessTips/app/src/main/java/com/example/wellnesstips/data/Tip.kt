package com.example.wellnesstips.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
