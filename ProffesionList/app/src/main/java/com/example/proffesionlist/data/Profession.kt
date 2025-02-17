package com.example.proffesionlist.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Profession(
    @StringRes val nameResource: Int,
    val score: Int,
    @DrawableRes val imageResource: Int
)
