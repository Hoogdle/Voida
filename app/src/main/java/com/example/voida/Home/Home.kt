package com.example.voida.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.voida.Notification


@Composable
fun Home(){
    Column {
        Notification(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
            ,text = "홈 화면입니다. 할인 상품과 추천 상품을 확인할 수 있습니다."
        )
        SearchBar()
        SearchwithVocie()
    }
}

