package com.example.voida.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSearchBar

@Composable
fun SearchBar(){

    var input by remember{mutableStateOf("")}
    Row(
        modifier = Modifier
            .padding(10.dp)
    ){
        BasicTextField(
            state = TextFieldState(initialText = "검색"),
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 15.sp
            ),
            decorator = {innerTextField ->
                Row(
                    modifier = Modifier
                        .height(30.dp)
                        .width(250.dp)
                        .background(DefaultSearchBar)
                ){
                    painterResource(R.dr)
                    innerTextField()
                }
            }
        )
    }
}