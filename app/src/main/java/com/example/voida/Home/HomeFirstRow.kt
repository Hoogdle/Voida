package com.example.voida.Home

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.core.content.ContextCompat.getString
import com.example.voida.Product
import com.example.voida.R
import com.example.voida.ui.theme.Item




val sample: Product = Product(
    image = R.drawable.home_1_1,
    eta = "무료배송\n" +
            "화요일 3/18 도착 예정",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "\"특가\" 어성초 천연비누 (어성초 자연유래 클렌징 비누) 천연 비누, 110g, 24개\n",
    price = 44450
)

@Composable
fun HomeFirstRow(){
    Item(sample)
}

