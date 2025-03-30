// order of modifier's attribute is important!

package com.example.voida.Basket

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton
import com.example.voida.ui.theme.SystemBackGround
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemETAColor
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemTextColor

@Composable
fun Basket(
    basketList: List<BasketData>,
    modifier: Modifier
){
    val scrollState = rememberScrollState()
    var price = 0

    var openDialog = remember{ mutableStateOf(false) }
    var isChanged = remember{ mutableStateOf(false) }
    var itemIndex = remember{ mutableStateOf(-1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SystemBackGround)
            .padding(10.dp)
            .verticalScroll(scrollState)

    ) {

        Notification(
            modifier = Modifier,
            text = "장바구니 화면입니다. 결제를 원하시면 화면 최하단의 결제하기 버튼을 눌러주세요."
        )
        Spacer(modifier = Modifier.height(15.dp))

        basketList.forEachIndexed {index, item ->
            BasketItem(
                item = item,
                openDialog = openDialog,
                itemIndex = itemIndex,
                index = index
            )
            Spacer(modifier = Modifier.height(10.dp))

            price += item.price * item.num.value
        }

        BasketPayButton(
            modifier = Modifier,
            price = price
        )
    }

    // end of Column area
    if(openDialog.value){
        val tmpNum = remember{basketList[itemIndex.value].num.value}
        Dialog(
            // if touch outside of dialog, dismiss it.(for debugging use it)
            onDismissRequest = {
                openDialog.value = false
            }
        ) {
            BasketNumChangeDialog(
                basketList[itemIndex.value],
                isChanged
            )

        }
    }
}

@Composable
fun BasketItem(
    item: BasketData,
    openDialog: MutableState<Boolean>,
    itemIndex: MutableState<Int>,
    index: Int
){
    Row(
        modifier = Modifier.background(color = SystemSelectButton)
    ){
        BasketImg(item)
        Column {
            BasketText(
                item = item
            )
            BasketButtonPack(
                item = item,
                openDialog = openDialog,
                itemIndex = itemIndex,
                index = index
            )
        }
    }
}

@Composable
fun BasketImg(
    item: BasketData
){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .width(170.dp)
        .height(170.dp)
        .padding(5.dp)
    ){
        Image(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            painter = painterResource(item.image),
            contentDescription = "상품 이미지" + item.name,
        )
    }
}

@Composable
fun BasketText(
    item: BasketData
){

    val formater: DecimalFormat = DecimalFormat("#,###,###,###,###")
    val price: String = formater.format(item.price)
    Column (modifier = Modifier.padding(5.dp)){
        Text(
            modifier = Modifier.width(150.dp),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            text = item.name,
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.eta,
            style = TextStyle(
                color = SystemETAColor,
                fontSize = 11.sp
            )
        )
        Spacer(modifier = Modifier.height(2.dp))

        // review block
        Row {
            Column {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.star),
                    contentDescription = "리뷰 이미지",
                )
            }

            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = item.score,
                style = TextStyle(
                    color = SystemTextColor,
                    fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                    fontSize = 10.sp
                )
            )
        }

        Text(
            text = price + "원" + "(${item.num.value}개)",
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun BasketButtonPack(
    item: BasketData,
    openDialog: MutableState<Boolean>,
    itemIndex: MutableState<Int>,
    index: Int
){
    Row(){
        // 상품 정보 변경 버튼
        BasketButton(
            text = "상품정보",
            modifier = Modifier.weight(1f),
            item = item,
            onClick = {}
        )
        
        // 개수 변경 버튼
        BasketButton(
            text = "개수변경",
            modifier = Modifier.weight(1f),
            item = item,
            onClick = {
                openDialog.value = true
                itemIndex.value = index
            }
        )
    }
}

@Composable
fun BasketButton(
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

@Composable
fun BasketPayButton(
    modifier: Modifier,
    price: Int
){

    val formater: DecimalFormat = DecimalFormat("#,###,###,###,###")
    val resultPrice: String = formater.format(price)
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = {},
        colors = ButtonColors(
            contentColor = SystemButtonTextColor,
            containerColor = SystemButtonColor,
            disabledContentColor = SystemButtonTextColor,
            disabledContainerColor = SystemButtonColor
        )
    ) {
        Text(
            text = "${resultPrice}원 결제하기",
            style = TextStyle(
                color = SystemButtonTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 18.sp
            )
        )
    }
}


