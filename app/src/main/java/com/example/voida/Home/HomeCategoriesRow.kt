package com.example.voida.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSearchBar

val sampleList = listOf("뷰티","식품","스포츠/레저","가전/디지털","헬스/건강식품")
@Composable
fun HomeCategoriesRow(
    modifier: Modifier,
    categoryList : List<String> = sampleList,
){
    Box(
        modifier = Modifier
            .clip(
                shape = RoundedCornerShape(15.dp)
            )
    ){
        LazyRow(
            modifier = Modifier
                .padding(
                    start = 10.dp,
                    end = 10.dp
                )
                .background(color = DefaultSearchBar)
                .clip(shape = RoundedCornerShape(15.dp))
        ){
            items(items = categoryList){
                    item ->

                Column {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        modifier = Modifier
                            .clickable {  }
                        ,
                        text = item,
                        style = TextStyle(
                            fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                        )
                    )
                }

                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painterResource(R.drawable.right_arrow),
                    contentDescription = "",
                    tint = Color.Black
                )


            }
        }
    }
}