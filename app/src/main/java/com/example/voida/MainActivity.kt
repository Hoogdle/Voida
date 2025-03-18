package com.example.voida

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.voida.Home.Home
import com.example.voida.ui.theme.DefaultSearchBar
import com.example.voida.ui.theme.VoidaTheme
import androidx.compose.ui.geometry.Offset

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val navItemList = listOf(
            NavItem(label = "홈 화면으로 이동합니다", icon = R.drawable.home),
            NavItem(label = "카테고리 화면으로 이동합니다", icon = R.drawable.categories),
            NavItem(label = "돋보기 화면으로 이동합니다", icon = R.drawable.nav_search),
            NavItem(label = "장바구니 화면으로 이동합니다", icon = R.drawable.shopping_cart),
            NavItem(label = "계정설정 화면으로 이동합니다", icon = R.drawable.user)
        )


        setContent {
            var selectedIndex by remember { mutableStateOf(0) }
            var scale by remember { mutableStateOf(1f) }
            var offsetX by remember { mutableStateOf(0f) }
            var offsetY by remember { mutableStateOf(0f) }
            var initialOffset by remember { mutableStateOf(Offset(0f, 0f)) }

            VoidaTheme {

                Scaffold(

                    //  < bottom navigation bar
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier
                                .border(
                                    width = 1.dp,
                                    color = Color.LightGray
                                ),
                            contentColor = Color.Black,
                            containerColor = Color.White,
                        ) {
                            navItemList.forEachIndexed { index, navItem ->
                                when(index){
                                    2 -> NavigationBarItem(
                                        modifier = Modifier
                                            .height(35.dp)
                                            .padding(bottom = 15.dp)
                                        ,
                                        selected = selectedIndex == index,
                                        onClick = {
                                            selectedIndex = index

                                            // set level of scale seems like good 1 -> 2 -> 3
                                            if(scale == 1f){
                                                scale = 2f
                                            } else {
                                                scale = 1f
                                            }
                                        },
                                        icon =  {
                                            Icon(
                                                painter = painterResource(navItem.icon),
                                                tint = Color.Black,
                                                contentDescription = navItem.label,

                                            )
                                        }
                                    )

                                    else -> NavigationBarItem(
                                        modifier = Modifier
                                            .height(35.dp),

                                        selected = selectedIndex == index,
                                        onClick = {
                                            selectedIndex = index
                                        },
                                        icon =  {
                                            Icon(
                                                painter = painterResource(navItem.icon),
                                                tint = Color.Black,
                                                contentDescription = navItem.label,
                                                modifier = Modifier
                                            )
                                        }
                                    )
                                }

                            }
                        }
                    }
                    // bottom navigation bar>

                ) {
                    inner ->
                    Box(
                        modifier = Modifier
                            .padding(inner)
                            .fillMaxSize()
                            .pointerInput(Unit){
                                detectTransformGestures{_, pan, _, _ ->


                                    if (pan != Offset(0f, 0f) && initialOffset == Offset(0f, 0f)) {
                                        initialOffset = Offset(offsetX, offsetY)
                                    }
                                }
                            }
                            .graphicsLayer {
                                scaleX = scale
                                scaleY = scale
                                translationX = offsetX
                                translationY = offsetY
                            }

                    ){
                        Home(modifier = Modifier.padding(inner))
                    }
                }
            }
        }
    }
}

