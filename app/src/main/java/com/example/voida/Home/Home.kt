package com.example.voida.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.voida.Notification
import com.example.voida.SearchBar


@Composable
fun Home(

){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Notification(
            modifier = Modifier
                .padding(10.dp)
            ,text = "홈 화면입니다. 할인 상품과 추천 상품을 확인할 수 있습니다."
        )
        SearchBar()
        HomeSemiButton("판매자 특가")
        HomeFirstRow()
    }
}

