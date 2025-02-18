package com.example.wooflist.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Woof(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)
