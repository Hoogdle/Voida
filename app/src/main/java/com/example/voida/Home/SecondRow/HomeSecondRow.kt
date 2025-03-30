package com.example.voida.Home.SecondRow

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voida.Home.samples
import com.example.voida.Item
import com.example.voida.R
import com.example.voida.ui.theme.SystemTextColor

val sampleSecond1: Product = Product(
    image = R.drawable.home_2_1,
    name = "고메 모짜렐라 돈카츠 (냉동), 450g, 1개",
    price = 8890
)

val sampleSecond2: Product = Product(
    image = R.drawable.home_2_2,
    name = "꽃게액젓 이영자 전현무 전참시 우리랑 파김치 레시피, 500ml, 1개\n",
    price = 13100
)

val sampleSecond3: Product = Product(
    image = R.drawable.home_2_3,
    name = "햇반 김치치즈 주먹밥 (냉동), 500g, 1개",
    price = 7980
)

val sampleSecond = listOf(sampleSecond1, sampleSecond2, sampleSecond3)

@Composable
fun HomeSecondRow(
    items: List<Product> = sampleSecond
){
    LazyRow {
        items(items = items){
                item ->
            HomeSecondRowItem(item)
        }
    }
}

@Composable
fun HomeSecondRowItem(
    product: Product
){

    val formater: DecimalFormat = DecimalFormat("#,###,###,###,###")
    val price: String = formater.format(product.price)

    Column(
        modifier = Modifier
            .padding(
                start = 10.dp,
                end = 10.dp
            )
    ){
        Box(modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .width(200.dp)
            .height(200.dp)
        ){
            Image(
                painter = painterResource(product.image),
                contentDescription = "상품 이미지" + product.name,
            )
        }

        Spacer(modifier = Modifier.height(4.dp))


        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier.width(200.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = product.name,
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                fontSize = 20.sp
            )
        )


        Text(
            text = price + "원",
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}