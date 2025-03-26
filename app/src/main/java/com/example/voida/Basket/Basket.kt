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
import androidx.compose.runtime.remember
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
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton

@Composable
fun Basket(
    basketList: List<BasketData>,
    modifier: Modifier
){
    val scrollState = rememberScrollState()
    var price = 0

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
        Spacer(modifier = Modifier.height(15.dp))

        basketList.forEach {
            BasketItem(it)
            Spacer(modifier = Modifier.height(10.dp))

            price += it.price * it.num.value
        }

        BasketPayButton(
            modifier = Modifier,
            price = price
        )
    }
}

@Composable
fun BasketItem(
    item: BasketData
){
    Row(
        modifier = Modifier.background(color = DefaultSelectButton)
    ){
        BasketImg(item)
        Column {
            BasketText(
                item = item
            )
            BasketButtonPack(item = item)
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
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = item.eta,
            style = TextStyle(
                color = Color.LightGray,
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
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                    fontSize = 10.sp
                )
            )
        }

        Text(
            text = price + "원" + "(${item.num.value}개)",
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun BasketButtonPack(
    item: BasketData
){
    Row(){
        // 상품 정보 변경 버튼
        BasketButton(
            text = "상품정보",
            modifier = Modifier.weight(1f),
            item = item,
        )
        
        // 개수 변경 버튼
        BasketButton(
            text = "개수변경",
            modifier = Modifier.weight(1f),
            item = item,
        )
    }
}

@Composable
fun BasketButton(
    text: String,
    modifier: Modifier,
    item: BasketData,
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
            contentColor = Color.White,
            containerColor = Color.Black,
            disabledContentColor = Color.White,
            disabledContainerColor = Color.Black
        )
    ) {
        Text(
            text = "${resultPrice}원 결제하기",
            style = TextStyle(
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 18.sp
            )
        )
    }
}


