package com.example.voida

import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voida.ui.theme.DefaultNotify

@Composable
fun Notification(
    modifier: Modifier = Modifier,
    text: String
){
    Column(modifier = modifier){
        BasicText(
            modifier = Modifier
                .background(color = DefaultNotify)
                .fillMaxWidth()
                .padding(all = 10.dp),
            text = text,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_18_bold))
            ),
            autoSize = TextAutoSize.StepBased(minFontSize = 15.sp, maxFontSize = 25.sp, stepSize = 1.sp)
        )
    }

}