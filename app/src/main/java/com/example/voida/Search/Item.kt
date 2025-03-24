package com.example.voida.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
fun SearchItem(){

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
                fontFamily = FontFamily(Font(R.font.inter_18_regular)),
                fontSize = 20.sp
            )
        )

        Text(
            text = item.eta,
            style = TextStyle(
                color = Color.LightGray
            )
        )

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
                    fontFamily = FontFamily(Font(R.font.inter_18_regular))
                )
            )
        }

    }
}