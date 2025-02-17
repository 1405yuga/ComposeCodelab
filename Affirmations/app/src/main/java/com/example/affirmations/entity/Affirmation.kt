package com.example.affirmations.entity

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    @DrawableRes val imageResource: Int,
    @StringRes val stringResource: Int
)
