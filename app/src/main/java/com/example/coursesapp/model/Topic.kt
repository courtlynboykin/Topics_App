package com.example.coursesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.graphics.drawable.IconCompat.IconType

data class Topic (
    @StringRes val stringResourceId: Int,
    val classes: Int,
    @DrawableRes val imageResourceId: Int
)
