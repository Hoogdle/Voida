package com.example.voida.Basket

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.voida.ProductInfo.Review
import com.example.voida.R

// Todo, remove mutableState after building back-end finished. it just data format for temptation.

data class BasketData(
    val image: Int,
    val eta: String,
    val score: String,
    val name: String,
    val price: Int,
    val num: MutableState<Int>
)

val basket1 = BasketData(
    image = R.drawable.basket1,
    eta = "무료배송\n" +
            "내일(일) 3/16 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "레노버 2022 씽크패드 L15 AMD G3 15.6 라이젠5 Pro 라이젠 5000 시리즈",
    price = 661150,
    num = mutableStateOf(1)
)

val basket2 = BasketData(
    image = R.drawable.basket2,
    eta = "무료배송\n" +
            "수요일 3/19 도착 예정",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "[누적수입량1위] 20brix선별통관 달콤하고 크리미한 애플망고, 2kg 로얄특품(4..., 1개" ,
    price = 27900,
    num = mutableStateOf(2)
)

val basket3 = BasketData(
    image = R.drawable.basket3,
    eta = "무료배송\n" +
            "내일(일) 3/16 새벽 7시 전 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "프리미엄 가나 생쇼콜라 밀크앤오트 (냉동)\n",
    price = 19000,
    num = mutableStateOf(1)
)

val basket4 = BasketData(
    image = R.drawable.basket4,
    eta = "무료배송 \n" +
            "모레(목) 3/27 도착 예정",
    score = "리뷰 5점(43명 리뷰)",
    name = "오후의꽃 그린 화이트 한다발 그린 소재 생화 택배\n",
    price = 14800,
    num = mutableStateOf(1)
)

val basketList = listOf(basket1, basket2 , basket3, basket4)