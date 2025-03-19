package com.example.voida.Home

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.voida.Item
import com.example.voida.Product
import com.example.voida.R


val sample1: Product = Product(
    image = R.drawable.home_1_1,
    eta = "무료배송\n" +
            "화요일 3/18 도착 예정",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "\"특가\" 어성초 천연비누 (어성초 자연유래 클렌징 비누) 천연 비누, 110g, 24개\n",
    price = 44450
)

val sample2: Product = Product(
    image = R.drawable.home_1_2,
    eta = "무료배송\n" +
            "목요일 3/20 도착 예정",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "어글리파스텔 향수 남자 니치 선물하기좋은 자아, 55ml, 3개",
    price = 65600
)

val sample3: Product = Product(
    image = R.drawable.home_1_3,
    eta = "무료배송\n" +
            "내일(일) 3/16 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "록키스 포커스 온 링클 케어 아이크림, 40ml, 5개",
    price = 11200
)



val samples: List<Product> = listOf(sample1, sample2, sample3)



@Composable
fun HomeFirstRow(
    items: List<Product> = samples
){
    LazyRow {
        items(items = items){
            item ->
            Item(item)
        }
    }
}

