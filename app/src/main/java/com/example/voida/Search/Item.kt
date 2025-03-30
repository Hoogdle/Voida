// Button has default 'content padding'!
package com.example.voida.Search

import android.icu.text.DecimalFormat
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
import androidx.compose.runtime.MutableState
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
import androidx.navigation.NavController
import com.example.voida.Product
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton
import com.example.voida.ui.theme.SystemBackGround
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemETAColor
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemSelectedText
import com.example.voida.ui.theme.SystemTextColor

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



// Todo, manage buttons size
@Composable
fun SearchItem(
    sample: List<Product>,
    modifier: Modifier = Modifier,
    navController: NavController,
    resultInput: MutableState<String>
){
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
    ) {
        items(items = sample){ item ->
            Row(
                modifier = Modifier
                    .background(color = SystemSelectButton)
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
                ){
                    SearchItemText(item)
                    SearchButtonPack(
                        navController = navController,
                        resultInput = resultInput
                    )
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
fun SearchItemText(
    item: Product
){
    val formater: DecimalFormat = DecimalFormat("#,###,###,###,###")
    val price: String = formater.format(item.price)

    Column {
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
                    tint = SystemTextColor
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
            text = price + "원",
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}

@Composable
fun SearchItemButton(
    modifier: Modifier,
    navController: NavController,
    resultInput: MutableState<String>
){
    Row {
        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = modifier
                .height(35.dp)
                .padding(2.dp)
            ,
            colors = ButtonColors(
                contentColor = SystemButtonTextColor,
                containerColor = SystemButtonColor,
                disabledContentColor = SystemButtonTextColor,
                disabledContainerColor = SystemButtonColor
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {}
        ) {
            Text(
                maxLines = 1,
                text = "장바구니",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SystemButtonTextColor,
                    fontFamily = FontFamily(Font(R.font.inter_18_medium))

            ))
        }
        Button(
            contentPadding = PaddingValues(0.dp),
            modifier = modifier
                .height(35.dp)
                .padding(2.dp)
            ,
            colors = ButtonColors(
                contentColor = SystemButtonTextColor,
                containerColor = SystemButtonColor,
                disabledContentColor = SystemButtonTextColor,
                disabledContainerColor = SystemButtonColor
            ),
            shape = RoundedCornerShape(5.dp),
            onClick = {
                navController.navigate("productInfo")
            }
        ) {
            Text(
                maxLines = 1,
                text = "상품정보",
                style = TextStyle(
                    fontSize = 12.sp,
                    color = SystemButtonTextColor,
                    fontFamily = FontFamily(Font(R.font.inter_18_medium))
                )
            )
        }
    }
}


@Composable
fun SearchButtonPack(
    navController: NavController,
    resultInput: MutableState<String>
){
    Row(){
        SearchButton(
            onClickAction = {},
            text = "장바구니",
            modifier = Modifier.weight(1f)
        )
        SearchButton(
            onClickAction = {
                navController.navigate("productInfo")
            },
            text = "상품정보",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SearchButton(
    onClickAction: () -> Unit,
    text: String,
    modifier: Modifier
){
    Button(
        modifier = modifier
            .height(35.dp)
            .padding(2.dp),
        shape = RoundedCornerShape(5.dp),
        contentPadding = PaddingValues(0.dp),
        onClick = {
            onClickAction()
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