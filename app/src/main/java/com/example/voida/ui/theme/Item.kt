package com.example.voida.ui.theme

import android.icu.text.DecimalFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun Item(
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

        Text(
            text = product.eta,
            style = TextStyle(
                color = Color.LightGray,
                )
        )

        Spacer(modifier = Modifier.height(5.dp))
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
                text = product.score,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.inter_18_regular))
                )
            )
        }
        Text(
            modifier = Modifier.width(200.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            text = product.name,
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                fontSize = 20.sp
            )
        )


        Text(
            text = price + "원",
            style = TextStyle(
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.inter_18_medium)),
                fontSize = 24.sp
            )
        )
    }
}