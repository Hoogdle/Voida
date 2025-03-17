package com.example.voida

import android.media.Image

data class Product(
    val image: Image,
    val eta: String,
    val score: String,
    val name: String,
    val price: Int
)
