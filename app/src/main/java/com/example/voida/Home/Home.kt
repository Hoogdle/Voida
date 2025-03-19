package com.example.voida.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.voida.Home.SecondRow.HomeSecondRow
import com.example.voida.Notification
import com.example.voida.SearchBar


@Composable
fun Home(
    modifier: Modifier
){

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(scrollState)
    ) {
        Notification(
            modifier = Modifier
                .padding(10.dp)
            ,text = "홈 화면입니다. 할인 상품과 추천 상품을 확인할 수 있습니다."
        )
        SearchBar()
        HomeSemiButton("판매자 특가")
        HomeFirstRow()
        Notification(
            modifier = Modifier
                .padding(10.dp)
            ,text = "아래에 원하시는 상품 카테고리를 선택해주세요. 추천 상품을 조회할 수 있습니다."
        )
        HomeCategoriesRow(modifier = Modifier.clip(RoundedCornerShape(10.dp)))
        Spacer(modifier = Modifier.height(20.dp))
        HomeSemiButton("식품")
        HomeSecondRow()
        Spacer(modifier = Modifier.height(50.dp))
    }
}

