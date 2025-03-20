package com.example.voida.Categories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.voida.Categories.Data.beauty
import com.example.voida.Categories.Data.birthandKids

import com.example.voida.Categories.Data.fashion
import com.example.voida.Categories.Data.food
import com.example.voida.Categories.Data.kitchen
import com.example.voida.ui.theme.DefaultSelectButton

val FirstList = listOf(fashion, fashion)

@Composable
fun Categories(){
    LazyColumn(

    ) {
        items(items = FirstList){
            item ->
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(DefaultSelectButton),
                shape = RectangleShape,
                onClick = {}
            ) {
                Text(
                    text = item.name// make only one class as Frame and make instance by only that!
                )
            }
        }
    }
}