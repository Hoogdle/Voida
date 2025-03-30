package com.example.voida.HighContrast

import com.example.voida.R

data class HighContrastData(
    val icon: Int,
    val name: String
)

val high1 = HighContrastData(
    icon = R.drawable.cont1,
    name = "검정·흰색(기본값)"
)

val high2 = HighContrastData(
    icon = R.drawable.cont2,
    name = "청록·연분홍"
)

val high3 = HighContrastData(
    icon = R.drawable.cont3,
    name = "남색·연하늘"
)
val high4 = HighContrastData(
    icon = R.drawable.cont4,
    name = "치색·노랑"
)

val high5 = HighContrastData(
    icon = R.drawable.cont5,
    name = "남색·연분홍"
)

val high6 = HighContrastData(
    icon = R.drawable.cont6,
    name = "남색·노랑"
)

val high7 = HighContrastData(
    icon = R.drawable.cont7,
    name = "청록·노랑"
)

val high8 = HighContrastData(
    icon = R.drawable.cont8,
    name = "적색·연하늘"
)

val high9 = HighContrastData(
    icon = R.drawable.cont9,
    name = "적색·노랑"
)


val highContrastList = listOf(high1,high2,high3,high4,high5,high6,high7,high8, high9)