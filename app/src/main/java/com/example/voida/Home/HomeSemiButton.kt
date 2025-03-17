package com.example.voida.Home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.example.voida.R

@Composable
fun HomeSemiButton(
    text : String
){
    Row(
        modifier = Modifier.padding(10.dp)
    ){

        // by Box make custom icon for button '>'
        // put the text left to above compose
        Card() {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.inter_18_bold))
                )
            )
        }
    }
}