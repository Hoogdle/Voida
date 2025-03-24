// Button has default 'content padding'!
package com.example.voida.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.voida.Product
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton

val sample1: Product = Product(
    image = R.drawable.search1,
    eta = "무료배송\n" +
            "오늘(일) 3/16 오후 8시 전 도착 보장",
    score = "리뷰 4.5점(168,135명 리뷰)",
    name = "곰곰 세척 사과, 2kg(소과), 1개\n" +
            "\n",
    price = 17990
)

val searchSampleList = listOf(sample1, sample1, sample1, sample1, sample1)

@Composable
fun SearchItem(
    sample: List<Product>,
    modifier: Modifier = Modifier
        .padding(
            start = 10.dp,
            end = 10.dp
        )
){
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
    ) {
        items(items = sample){ item ->
            Row(
                modifier = Modifier
                    .background(color = DefaultSelectButton)
                    .padding(
                        end = 20.dp
                    )
            ) {
                SearchItemImg(modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
                    ,
                    item
                )
                Column(modifier = Modifier
                    .padding(5.dp)
                    .weight(1.3f)
                ){
                    SearchItemText(item)
                    SearchItemButton()
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }
    }

}

@Composable
fun SearchItemImg(
    modifier : Modifier,
    item: Product
){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(16.dp))
        .width(170.dp)
        .height(170.dp)
        .padding(2.dp)
    ){
        Image(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            painter = painterResource(item.image),
            contentDescription = "상품 이미지" + item.name,
        )
    }

}

@Composable
fun SearchItemText(
    item: Product
){
    Column {
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
                Spacer(modifier = Modifier.height(2.3.dp))
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
            text = item.price.toString() + "원",
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun SearchItemButton(){
    Row {
        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .padding(1.dp)
            ,
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {}
        ) {
            Text(
                maxLines = 1,
                text = "장바구니",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_18_medium))

            ))
        }
        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .weight(1f)
                .height(40.dp)
                .padding(1.dp)
            ,
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Black
            ),
            shape = RoundedCornerShape(15.dp),
            onClick = {}
        ) {
            Text(
                maxLines = 1,
                text = "상품정보",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.inter_18_medium))

                )
            )
        }
    }
}