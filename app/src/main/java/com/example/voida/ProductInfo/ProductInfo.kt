package com.example.voida.ProductInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.Search.SearchItemButton
import com.example.voida.Search.SearchItemImg
import com.example.voida.Search.SearchItemText
import com.example.voida.ui.theme.DefaultSelectButton

@Composable
fun ProductInfo(
    item: ProductInfoData
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ){
        Notification(
            modifier = Modifier.padding(10.dp),
            text = "‘${item.name}’ 상품 화면입니다. 요약된 상품 정보와 리뷰를 제공받을 수 있습니다. 상품구매를 원하시면 최하단의 ‘장바구니 버튼’ 또는 ‘구매하기’ 버튼을 눌러주세요."
        )
        ProductInfoItem(item)
    }
}

@Composable
fun ProductInfoItem(
    item: ProductInfoData
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(color = DefaultSelectButton)
    ){
        ProductInfoImg(item)
        ProductInfoText(item)
    }
}

@Composable
fun ProductInfoImg(
    item: ProductInfoData
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
fun ProductInfoText(
    item: ProductInfoData
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
fun ProductInfoItemInfo(){

}

@Composable
fun ProductInfoItemReviews(){

}
