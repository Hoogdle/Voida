package com.example.voida.ProductInfo

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
import androidx.compose.material3.HorizontalDivider
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
import com.example.voida.ui.theme.SystemBackGround
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemETAColor
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemTextColor
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun ProductInfo(
    item: ProductInfoData
){
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SystemBackGround)
            .verticalScroll(scrollState)
    ){
        Notification(
            modifier = Modifier.padding(10.dp),
            text = "‘${item.name}’ 상품 화면입니다. 요약된 상품 정보와 리뷰를 제공받을 수 있습니다. 상품구매를 원하시면 최하단의 ‘장바구니 버튼’ 또는 ‘구매하기’ 버튼을 눌러주세요."
        )
        ProductInfoItem(item)
        Spacer(modifier = Modifier.height(15.dp))
        ProductInfoItemInfo(item = item)
        Spacer(modifier = Modifier.height(15.dp))
        ProductInfoItemReviews(item = item)
        ProductInfoButtonPack()

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
            .background(color = SystemSelectButton),
    ){
        ProductInfoImg(
            item = item,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Spacer(modifier = Modifier.height(20.dp))
            ProductInfoText(
                item = item,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun ProductInfoImg(
    item: ProductInfoData,
    modifier: Modifier
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
    item: ProductInfoData,
    modifier: Modifier
){

    val formater: DecimalFormat = DecimalFormat("#,###,###,###,###")
    val price: String = formater.format(item.price)
    Column(modifier = modifier){
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
fun ProductInfoItemInfo(
    item: ProductInfoData
){

    Column(
        modifier = Modifier.padding(10.dp)
    ){
        Text(
            text = "상품정보",
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 18.sp
            )
        )
        HorizontalDivider(
            color = SystemTextColor,
            thickness = 2.dp
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = item.productInfo,
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                fontSize = 18.sp
            )
        )
    }
}

@Composable
fun ProductInfoItemReviews(
    item: ProductInfoData
){
    Column(
        modifier = Modifier.padding(12.dp)
    ){
        Text(
            text = "리뷰정보",
            style = TextStyle(
                color = SystemTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 18.sp
            )
        )
        HorizontalDivider(
            color = SystemTextColor,
            thickness = 2.dp
        )
        Spacer(modifier= Modifier.height(8.dp))
        item.reviewInfo.forEach {
            Text(
                text = it.title,
                style = TextStyle(
                    color = SystemTextColor,
                    fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                    fontSize = 18.sp
                )
            )
            Text(
                text = it.contents,
                style = TextStyle(
                    color = SystemTextColor,
                    fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Composable
fun ProductInfoButtonPack(){
    Row(
        modifier = Modifier.padding(10.dp)
    ){
        ProductInfoButton(
            text = "장바구니 담기",
            modifier = Modifier
                .padding(2.dp)
                .weight(1f)
        )
        ProductInfoButton(
            text = "구매하기",
            modifier = Modifier
                .padding(2.dp)
                .weight(1f)
        )
    }
}

@Composable
fun ProductInfoButton(
    text: String,
    modifier: Modifier
){
    Button(
        shape = RoundedCornerShape(5.dp),
        modifier = modifier
            .height(50.dp),
        onClick = {},
        colors = ButtonColors(
            containerColor = SystemButtonColor,
            contentColor = SystemButtonTextColor,
            disabledContentColor = SystemButtonTextColor,
            disabledContainerColor = SystemButtonColor
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = text,
            style = TextStyle(
                color = SystemButtonTextColor,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 15.sp
            )
        )
    }
}

