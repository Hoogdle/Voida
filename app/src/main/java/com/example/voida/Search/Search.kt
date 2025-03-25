package com.example.voida.Search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.voida.Notification
import com.example.voida.Product
import com.example.voida.R
import com.example.voida.SearchBar


// Todo, control exception according to user input

val sample: Product = Product(
    image = R.drawable.search1,
    eta = "무료배송\n" +
            "오늘(일) 3/16 오후 8시 전 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "곰곰 세척 사과, 2kg(소과), 1개\n" +
            "\n",
    price = 17990
)

@Composable
fun Search(
    input: MutableState<String>,
    navController: NavController
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
    ){
        val tmpInput = remember {input.value}

        Notification(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    top = 10.dp,
                    end = 10.dp,
                    bottom = 3.dp
                ),
            text = "'${tmpInput}' 검색결과 입니다."
        )
        SearchBar(navController = navController, resultInput = input)
        SearchItem(
            sample = searchSampleList,
            navController = navController,
            resultInput = input
        )
    }
}