package com.example.voida.HighContrast

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton
import com.example.voida.ui.theme.HighContrastBlue
import com.example.voida.ui.theme.HighContrastNotifyBlue
import com.example.voida.ui.theme.HighContrastPink
import com.example.voida.ui.theme.HighContrastSearchBlue
import com.example.voida.ui.theme.HighContrastSelectedBlue
import com.example.voida.ui.theme.SystemBackGround
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemNotify
import com.example.voida.ui.theme.SystemSearchBar
import com.example.voida.ui.theme.SystemSearchHelper
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemSelectedText
import com.example.voida.ui.theme.SystemTextColor


// Todo, this is temporary for presentation, after that include it into account


@Composable
fun HighContrast(
    modifier: Modifier,
    highContrastList: List<HighContrastData>
){
    val selectedHighContrast = remember{ mutableStateListOf(false, false, false, false, false, false, false, false, false) }
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = SystemBackGround)
            .padding(10.dp)
            .verticalScroll(scrollState)
    ) {
        Notification(
            modifier = Modifier,
            text = "‘고대비 설정’ 화면 입니다. 아래의 목록 중 원하는 고대비 테마를 선택해주세요."
        )

        Spacer(modifier = Modifier.height(20.dp))

        highContrastList.forEachIndexed { index, item ->
            HighContrastPerRow(
                item = item,
                index= index,
                selectedHighContrast = selectedHighContrast
            )
            if(selectedHighContrast[index]){
                HighContrastSelectedInform(item = item)
            }
            Spacer(modifier = Modifier.height(4.dp))
        }


    }
}

@Composable
fun HighContrastSelectedInform(
    item: HighContrastData,
){
    Notification(
        modifier = Modifier,
        text = "${item.name}을 선택하셨습니다. 아래의 ‘체험하기’ 또는 ‘선택’ 버튼을 눌러주세요. ‘체험하기’를 누르면 해당 테마를 간단하게 체험할 수 있습니다. ‘선택’을 누르시면 해당 테마가 바로 적용됩니다."
    )
    HighContrastButtonPack()

}

@Composable
fun HighContrastPerRow(
    item: HighContrastData,
    index: Int,
    selectedHighContrast: MutableList<Boolean>
){
    Button(
        colors = ButtonColors(
            contentColor = SystemTextColor,
            containerColor = SystemSelectButton,
            disabledContentColor = SystemTextColor,
            disabledContainerColor = SystemSelectButton
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(DefaultSelectButton),
        shape = RectangleShape,
        onClick = {
            if(selectedHighContrast[index]){

                selectedHighContrast[index] = false
            } else {
                for (i in 0..8){
                    if(i != index){
                        selectedHighContrast[i] = false
                    }
                }
                selectedHighContrast[index] = true
            }
        }
    ) {


        Icon(
            painter = painterResource(item.icon),
            contentDescription = "",
            modifier = Modifier
                .size(30.dp),
            tint = Color.Unspecified
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
}


@Composable
fun HighContrastButtonPack(){
    Row {
        HighContrastButton(
            modifier = Modifier.weight(1f),
            text = "체험하기"
        )
        HighContrastButton(
            modifier = Modifier.weight(1f),
            text = "선택"
        )
    }
}


@Composable
fun HighContrastButton(
    modifier: Modifier,
    text: String
){
    Button(
        onClick = {
            changeSystemColor()
        },
        shape = RectangleShape,
        contentPadding = PaddingValues(2.dp),
        colors = ButtonColors(
            contentColor = SystemButtonTextColor,
            containerColor = SystemButtonColor,
            disabledContentColor = SystemButtonTextColor,
            disabledContainerColor = SystemButtonColor
        ),
        modifier = modifier
    ){
        Text(
            modifier = Modifier
                .weight(1f),
            textAlign = TextAlign.Center,
            text = text,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 20.sp
            )

        )
    }
}

fun changeSystemColor(){
    SystemBackGround = HighContrastBlue
    SystemTextColor = HighContrastPink
    SystemSelectButton = HighContrastSelectedBlue
    SystemButtonColor = HighContrastPink
    SystemButtonTextColor = HighContrastBlue
    SystemSelectedText = HighContrastPink
    SystemNotify = HighContrastNotifyBlue
    SystemSearchBar = HighContrastSearchBlue
    SystemSearchHelper = HighContrastPink
}

// good!!!!
//SystemBackGround = HighContrastBlue
//SystemTextColor = HighContrastPink