package com.example.voida.Categories

import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import beauty
import birthAndKids

import com.example.voida.Categories.Data.fashion
import com.example.voida.Categories.Data.kitchen
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton
import food

val FirstList = listOf(fashion, beauty, birthAndKids, food, kitchen)

@Composable
fun Categories(
    modifier: Modifier
){
    // selectedIndex 로 값을 저장하고 카테고리 박스 클릭시 이벤트 발생 -> 인덱스 설정 -> show up
    // selectedIndex 을 여러개 두어야..
    // 카테고리 화면을 나가면 selectedIndex를 초기화 해야만!

    val selectedIndex by remember { mutableStateOf(listOf(-1,-1,-1,-1,-1)) }

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(10.dp)
    ){
        Notification(
            modifier = Modifier,
            text = "카테고리 화면입니다. 원하는 상품 종류를 선택해주세요."
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier

        ) {

            items(items = FirstList){
                    item ->
                    Button(
                        colors = ButtonColors(
                            contentColor = Color.Black,
                            containerColor = DefaultSelectButton,
                            disabledContentColor = Color.Black,
                            disabledContainerColor = DefaultSelectButton
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(DefaultSelectButton),
                        shape = RectangleShape,
                        onClick = {
                            //for
                        }
                    ) {


                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = "",
                            modifier = Modifier
                                .size(30.dp)
                        )


                        Text(
                            modifier = Modifier
                                .weight(1f),
                            textAlign = TextAlign.Center,
                            text = item.name,
                            style = TextStyle(
                                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                                fontSize = 20.sp
                            )

                        )
                    }
                Spacer(modifier = Modifier.padding(5.dp))

            }
        }
    }
}