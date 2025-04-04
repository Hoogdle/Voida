package com.example.voida.Categories

// Done 25/03/24
// Todo, add animation
// Todo, arrange the item as Real data in the coupang
// Todo, Clear the debugging soruce

import android.graphics.Paint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
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
import com.example.voida.Categories.Data.Category
import com.example.voida.Categories.Data.SubCategory

import com.example.voida.Categories.Data.fashion
import com.example.voida.Categories.Data.homeAppliances
import com.example.voida.Categories.Data.homeInterior
import com.example.voida.Categories.Data.houseHoldItems
import com.example.voida.Categories.Data.kitchen
import com.example.voida.Notification
import com.example.voida.R
import com.example.voida.ui.theme.DefaultSelectButton
import com.example.voida.ui.theme.SystemBackGround
import com.example.voida.ui.theme.SystemButtonColor
import com.example.voida.ui.theme.SystemButtonTextColor
import com.example.voida.ui.theme.SystemSelectButton
import com.example.voida.ui.theme.SystemSelectedText
import com.example.voida.ui.theme.SystemTextColor
import food

val FirstList = listOf(fashion, beauty, birthAndKids, food, kitchen, houseHoldItems, homeInterior, homeAppliances)

@Composable
fun Categories(
    modifier: Modifier
){

    // when call category from nav fun, put the  default paramrter as selectedIndexed(-1,-1,-1,-1,-1) => only when trigger the category button, indexing resetted.
    // can not use onStop()
    // selectedIndex 로 값을 저장하고 카테고리 박스 클릭시 이벤트 발생 -> 인덱스 설정 -> show up
    // selectedIndex 을 여러개 두어야..
    // 카테고리 화면을 나가면 selectedIndex를 초기화 해야만!

    // 어차피 Nav를 통해야만 다른 화면으로 나갈 수 있음.
    // Nav를 할 때 selectedIndex를 초기화 하는 방법도 좋고
    // Nav 관련 특수 메서드로 selectedIndex를 초기화하는 방법도 좋아 보임.


    // WTF LazyColumn!!!

    val selectedIndex = remember{ mutableStateListOf(-1,-1,-1,-1,-1)}
    var count = remember{ mutableStateOf(0) } // category counter 0 -> 1 -> 2 -> ..

    Column(
        modifier = Modifier
            .background(SystemBackGround)
            .fillMaxSize()
            .padding(10.dp)
    ){
        Notification(
            modifier = Modifier,
            text = "카테고리 화면입니다. 원하는 상품 종류를 선택해주세요."//${count.value} ${selectedIndex.toString()}" //Debugging
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            modifier = Modifier

        ) {
            itemsIndexed(items = FirstList){
                    index, item->


                    Button(
                        colors = ButtonColors(
                            contentColor = SystemSelectedText,
                            containerColor = SystemSelectButton,
                            disabledContentColor = SystemSelectedText,
                            disabledContainerColor = SystemSelectButton
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .background(DefaultSelectButton),
                        shape = RectangleShape,
                        onClick = {

                            // when click first category, reset the selectedIndex
                            for(i in 0..4){
                                selectedIndex[i] = -1
                                count.value = 0
                            }
                            selectedIndex[count.value] = index
                            count.value++

                            // Todo, occur array index overflow, need to filter out it!
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
                                fontSize = 20.sp,
                                color = SystemTextColor
                            )

                        )
                    }

                // use category selector with if conditions
                // count == 1
                if (index == selectedIndex[0]){
                    Notification(
                        modifier = Modifier,
                        text = "'${item.name}'를 선택하셨습니다. 원하는 상품 종류를 선택해주세요."
                    )


                    // there is no node that doesn't have any child.
                    if(item.child != null){ // not error here
                        listSubCategories(
                            child = item.child,
                            selectedIndex = selectedIndex,
                            listIndex = count
                        )

                        // has updated selectedIndex by listSubCategories



                        // child series start point


//                        if(selectedIndex[1] != -1){
//                            Notification(
//                                modifier = Modifier,
//                                text = "${item.child[selectedIndex[1]].name}을 선택하셨습니다. 상품의 세부 종류를 선택해주세요."
//                            )
//                            categorySelector(
//                                selected = item.child[selectedIndex[1]],
//                                selectedIndex = selectedIndex,
//                                listIndex = count
//                            )
//                            if(selectedIndex[2] != -1 && selectedChild.child != null){
//                                categorySelector(
//                                    selected = item.child[selectedIndex[2]],
//                                    selectedIndex = selectedIndex,
//                                    listIndex = count
//                                )
//                                if(selectedIndex[3] != -1){
//                                    categorySelector(
//                                        selected = item.child[selectedIndex[3]],
//                                        selectedIndex = selectedIndex,
//                                        listIndex = count
//                                    )
//                                    if(selectedIndex[4] != -1){
//                                        categorySelector(
//                                            selected = item.child[selectedIndex[4]],
//                                            selectedIndex = selectedIndex,
//                                            listIndex = count
//                                        )
//                                    }
//                                }
//                            }
                        }
                    }

                    // if there are no any child, just pass it.


                Spacer(modifier = Modifier.padding(5.dp))

            }
        }
    }
}

// helper function, show the all contents of selected item
@Composable
fun categorySelector(
    selected: SubCategory,
    selectedIndex: MutableList<Int>, // CBR
    listIndex: MutableState<Int>, // affect to source data, CBR
){
    Log.i("debug","1")
    if(selected.child != null && selected.parentTerminal == false){
        Log.i("debug","2")

        listSubCategories(
            child = selected.child,
            selectedIndex = selectedIndex,
            listIndex = listIndex
        )
    }
    else if(selected.parentTerminal == true && selected.terminalList != null){
        Log.i("debug","3")

        listTerminalCategories(
            terminalList = selected.terminalList,
            selectedIndex = selectedIndex,
            listIndex = listIndex
        )
    }
}

// show the all contents of selected item
@Composable
fun listSubCategories(
    child: List<SubCategory>,
    selectedIndex: MutableList<Int>, // CBR
    listIndex: MutableState<Int> // affect to source data, CBR
){

    // every button click occur re-compose
    Log.i("debug","recompose")

    var visible by remember { mutableStateOf(true) }
    val tmpIndex = listIndex.value - 1 // using in below array indexing
    val rememberedIndex = remember{tmpIndex}
    val density = LocalDensity.current

    Column {
        child.forEachIndexed { index, value ->
            Button(
                colors = ButtonColors(
                    contentColor = SystemSelectedText,
                    containerColor = SystemSelectButton,
                    disabledContentColor = SystemSelectedText,
                    disabledContainerColor = SystemSelectButton
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(DefaultSelectButton),
                shape = RectangleShape,
                onClick = {
                    var isClicked: Boolean = true

                    Log.i("debug","rememberIndex : ${rememberedIndex}")
                    if(selectedIndex[rememberedIndex+1] == index){
                        Log.i("debug","onclick function")

                        listIndex.value--
                        for(i in (rememberedIndex+1) .. 4){
                            selectedIndex[i] = -1
                        }

                        isClicked = false
                    } else if(selectedIndex[rememberedIndex+1] != -1 && selectedIndex[rememberedIndex+1] != index){
                        Log.i("debug","here!")
                        selectedIndex[rememberedIndex+1] = index
                        listIndex.value--
                    }

                    if(isClicked){
                        selectedIndex[rememberedIndex+1] = index
                        listIndex.value++
                    }
                }
            ){
                Text(
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    text = value.name,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                        fontSize = 20.sp,
                        color = SystemTextColor
                    )
                )
            }

            if(tmpIndex > 0){
                if(selectedIndex[rememberedIndex+1] == index){
                    Notification(
                        modifier = Modifier,
                        text = "'${value.name}'을 선택하셨습니다. 상품의 세부 종류를 선택해주세요."
                    )
                    Log.i("debug","after clicked selectedIndex : ${selectedIndex}, tmpIndex : ${tmpIndex}")

                    categorySelector(
                        selected = value,
                        selectedIndex = selectedIndex,
                        listIndex = listIndex
                    )

                }
            }
        }
    }
}

// show the all contents of terminal data
@Composable
fun listTerminalCategories(
    terminalList: List<String>,
    selectedIndex: MutableList<Int>,
    listIndex: MutableState<Int>
){
    Column {
        terminalList.forEachIndexed { index, value ->
            Button(
                colors = ButtonColors(
                    contentColor = SystemButtonTextColor,
                    containerColor = SystemSelectButton,
                    disabledContentColor = SystemButtonTextColor,
                    disabledContainerColor = SystemSelectButton
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(DefaultSelectButton),
                shape = RectangleShape,
                onClick = {
                    selectedIndex[listIndex.value] = index
                }
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    textAlign = TextAlign.Center,
                    text = value,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                        fontSize = 20.sp,
                        color = SystemTextColor
                    )
                )
            }

        }
    }
}

@Composable
fun CategoryAnimation(
    content : @Composable() () -> Unit
){

    var visible by remember { mutableStateOf(true) }
    val density = LocalDensity.current

    AnimatedVisibility(
        visible,
        enter = slideInVertically {
            // Slide in from 40 dp from the top.
            with(density) { -40.dp.roundToPx() }
        } + expandVertically(
            // Expand from the top.
            expandFrom = Alignment.Top
        ) + fadeIn(
            // Fade in with the initial alpha of 0.3f.
            initialAlpha = 0.3f
        ),
        exit = slideOutVertically() + shrinkVertically() + fadeOut()
    ){
        content()
    }
}