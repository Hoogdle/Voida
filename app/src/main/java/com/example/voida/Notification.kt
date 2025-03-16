package com.example.voida

import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

@Composable
fun Notification(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.inter_18_bold))

    )
}