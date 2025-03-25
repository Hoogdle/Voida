// order of modifier's attribute is important!

package com.example.voida.Basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.voida.Notification

@Composable
fun Basket(
    modifier: Modifier
){
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(10.dp)
            .verticalScroll(scrollState)

    ) {
        Notification(
            modifier = Modifier,
            text = "장바구니 화면입니다. 결제를 원하시면 화면 최하단의 결제하기 버튼을 눌러주세요."
        )
    }
}

@Composable
fun BasketItem(){

}

@Composable
fun BasketImg(){

}

@Composable
fun BasketText(){

}

@Composable
fun BasketButtonPack(){

}

@Composable
fun BasketButton(){

}

@Composable
fun PayButton(){

}


