package com.example.asus.mynetwork

import androidx.annotation.DrawableRes

data class New(
    val name: String,
    val text: String,
    @DrawableRes
    val img: Int,
    val type:String
)