package com.example.voida.Basket

import android.provider.Settings
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
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
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemTextColor


//Todo, finish the basket
@Composable
fun BasketNumChangeDialog(
    item: BasketData,
    isChanged: MutableState<Boolean>
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Notification(
            modifier = Modifier,
            text = "'${item.name}'의 상품 개수를 변경합니다. 현재 개수는 ${item.num.value}개 입니다."
        )
        Spacer(modifier = Modifier.height(20.dp))
        ChangingBox(
            item = item,
            isChanged = isChanged
        )
    }


}

@Composable
fun ChangingBox(
    item: BasketData,
    isChanged: MutableState<Boolean>
){
    // not use remember
    //var boxNum = MutableState<Int>
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SystemSelectButton)
            .padding(
                10.dp
            )
    ){
        Spacer(modifier = Modifier.height(20.dp))
        NumOfProduct(item = item)
        Spacer(Modifier.height(15.dp))
        BasketNumChangeButtonPack(
            item = item,
            isChanged = isChanged,
            boxNum = 2
        )
    }
}

@Composable
fun NumOfProduct(
    item: BasketData
){

    Text(
        textAlign = TextAlign.Center,
        modifier = Modifier
            .background(color = SystemButtonTextColor)
            .padding(
                start = 80.dp,
                end = 80.dp,
                top = 40.dp,
                bottom = 40.dp
            )
        ,
        text = "${item.num.value}개",
        style = TextStyle(
            color = SystemTextColor,
            fontFamily = FontFamily(Font(R.font.inter_18_bold)),
            fontSize = 25.sp
        )
    )
}

@Composable
fun BasketNumChangeButtonPack(
    item: BasketData,
    isChanged: MutableState<Boolean>,
    boxNum: Int
){

    Column(){
        Row {
            BasketNumChangeButton(
                text = "감소",
                modifier = Modifier.weight(1f),
                item = item,
                onClick = {
                    //boxNum -= 1
                }
            )
            BasketNumChangeButton(
                text = "증가",
                modifier = Modifier.weight(1f),
                item = item,
                onClick = {
                    item.num.value += 1
                }
            )
        }
        BasketNumChangeButton(
            text = "변경완료",
            modifier = Modifier.fillMaxWidth(),
            item = item,
            onClick = {
                isChanged.value = true
            }
        )
    }
}

@Composable
fun BasketNumChangeButton(
    text: String,
    modifier: Modifier,
    item: BasketData,
    onClick: () -> Unit,
){
    Button(
        modifier = modifier
            .height(35.dp)
            .padding(2.dp),
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = {
            onClick()
        },
        colors = ButtonColors(
            contentColor = SystemButtonTextColor,
            containerColor = SystemButtonColor,
            disabledContentColor = SystemButtonTextColor,
            disabledContainerColor = SystemButtonColor
        )
    ) {
        Text(
            text = text
        )
    }
}