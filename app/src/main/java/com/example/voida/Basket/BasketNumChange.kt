package com.example.voida.Basket

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.voida.Notification
import com.example.voida.ProductInfo.ProductInfoData
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton


//Todo, finish the basket
@Composable
fun BasketNumChangeDialog(
    item: BasketData
){
    Column(
        modifier = Modifier
            .padding(10.dp)
    ){
        Notification(
            modifier = Modifier,
            text = "'${item.name}'의 상품 개수를 변경합니다. 현재 개수는 ${item.num.value}개 입니다."
        )
        Spacer(modifier = Modifier.height(20.dp))
        ChangingBox(item = item)
    }


}

@Composable
fun ChangingBox(
    item: BasketData
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(color = DefaultSelectButton)
            .padding(
                start = 50.dp,
                end = 50.dp,
                top = 10.dp,
                bottom = 10.dp
            )
    ){
        NumOfProduct(item = item)
        Spacer(Modifier.height(15.dp))
        BasketNumChangeButtonPack(item = item)
    }
}

@Composable
fun NumOfProduct(
    item: BasketData
){

    Text(
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = Color.White)
            .padding(
                start = 80.dp,
                end = 80.dp,
                top = 40.dp,
                bottom = 40.dp
            )
        ,
        text = "${item.num.value}개",
        style = TextStyle(
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.inter_18_bold)),
            fontSize = 18.sp
        )
    )
}

@Composable
fun BasketNumChangeButtonPack(
    item: BasketData
){
    Column(){
        Row {
            BasketNumChangeButton(
                text = "감소",
                modifier = Modifier.weight(1f),
                item = item
            )
            BasketNumChangeButton(
                text = "증가",
                modifier = Modifier.weight(1f),
                item = item
            )
        }
        BasketNumChangeButton(
            text = "변경완료",
            modifier = Modifier.fillMaxWidth(),
            item = item
        )
    }
}

@Composable
fun BasketNumChangeButton(
    text: String,
    modifier: Modifier,
    item: BasketData
){
    Button(
        modifier = modifier
            .height(35.dp)
            .padding(2.dp),
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = {},
        colors = ButtonColors(
            contentColor = Color.White,
            containerColor = Color.Black,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.Black
        )
    ) {
        Text(
            text = text
        )
    }
}