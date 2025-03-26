package com.example.voida.Basket

import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.voida.Notification


// 1. use remember stat for show dialog or not
// 2. use Box to Basket and Dialog.
// 3. use modifier.alpha things for opacity of dialog.
// 4. @Preview(showBackground = true)
// 5. maybe if not use any Column or Row latest composable show very top of monitor.

// then just make Dialog and by conditions choose whether show it or not in the basket!
@Composable
fun BasketNumChangeDialog(
    onClickCancel: () -> Unit,
    item: BasketData
){
    Dialog(
        onDismissRequest = {},
        properties = DialogProperties(
            dismissOnClickOutside = true,
            dismissOnBackPress = true
        )
    ) {
        Notification(
            modifier = Modifier,
            text = "'${item.name}'의 상품 개수를 변경합니다. 현재 개수는 ${item.num.value}개 입니다."
        )
    }

}

@Composable
fun ChangingBox(
    item: BasketData
){

}