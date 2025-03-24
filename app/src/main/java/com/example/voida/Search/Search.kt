package com.example.voida.Search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.voida.Notification
import com.example.voida.SearchBar

@Composable
fun Search(
    input: String,
    navController: NavController
){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "hello")
//        Notification(
//            modifier = Modifier,
//            text = "'${input}' 검색결과 입니다."
//        )
//        Spacer(modifier = Modifier.height(5.dp))
//        SearchBar()

    }
}