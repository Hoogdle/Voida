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
import com.example.voida.Categories.Data.Beauty
import com.example.voida.Categories.Data.BirthandKids
import com.example.voida.Categories.Data.Fashion
import com.example.voida.Categories.Data.Food
import com.example.voida.Categories.Data.Kitchen
import com.example.voida.Categories.Data.fashion
import com.example.voida.ui.theme.DefaultSelectButton

val FirstList = listOf(fashion)

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
                    text = item.name // follow the Clothes example.
                )
            }
        }
    }
}