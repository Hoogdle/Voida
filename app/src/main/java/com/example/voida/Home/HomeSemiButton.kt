package com.example.voida.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSearchBar
import com.example.voida.ui.theme.SystemIconColor
import com.example.voida.ui.theme.SystemSearchBar
import com.example.voida.ui.theme.SystemTextColor

@Composable
fun HomeSemiButton(
    text : String
){
    Row(
        modifier = Modifier.padding(10.dp)
    ){

        // by Box make custom icon for button '>'
        // put the text left to above compose
        Card(
            colors = CardColors(
                containerColor = Color.Transparent,
                contentColor = SystemTextColor,
                disabledContentColor = SystemTextColor,
                disabledContainerColor = Color.Transparent
                ),
            modifier = Modifier
                .clickable {  }
        ) {
            Row(){
                Text(
                    text = text,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                        fontSize = 18.sp
                    ),
                )

                Spacer(modifier = Modifier.width(4.dp))

                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.right_arrow),
                    contentDescription = "검색버튼",
                    tint = SystemTextColor,
                    modifier = Modifier.background(
                        shape = CircleShape,
                        color = SystemSearchBar
                    )
                )
            }

        }


    }
}