package com.example.voida

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.voida.ui.theme.DefaultSearchBar

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.util.Locale



// TODO
// 1. make voice-search button
// 2. complete voice-search function

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(){

    val context = LocalContext.current
    var input by remember { mutableStateOf("") }
    val interactionSource = remember { MutableInteractionSource() }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = { result ->
            val spokenText =
                result.data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)?.firstOrNull()
            if (spokenText != null) {
                input = spokenText  // Update prompt with recognized text
            } else {
                Toast.makeText(context, "음성인식에 실패하였습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    )


    Row(
        modifier = Modifier
            .padding(
                horizontal = 10.dp,
                vertical = 5.dp
            )
    ){

        // Todo
        // 1. check why BTF Not working
        // => then almost done
        BasicTextField(

            modifier = Modifier
                .weight(2.8f)
                .clip(
                    shape = RoundedCornerShape(10.dp)
                ),
            value = input,
            onValueChange = {input = it},
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.inter_18_bold)),
                fontSize = 15.sp,
            ),
                decorationBox = {innerTextField ->


                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(45.dp)
                        .weight(4f)
                        .background(DefaultSearchBar)
                        .padding(10.dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                ){
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.search),
                        contentDescription = "검색 입력 란",
                        tint = Color(0x82828282)
                    )
                    Spacer(modifier = Modifier
                        .width(5.dp))


                    // TextField, using complicated way
                    Box(
                        modifier = Modifier
                            .border(
                                width = 1.dp,
                                color = DefaultSearchBar,
                                shape = RoundedCornerShape(20.dp)
                            ),

                    ){
                        if(input.isEmpty()){
                            Text(
                                text = "검색",
                                color = Color(0x82828282)
                            )
                        }
                        Column {
                            Spacer(modifier = Modifier.size(2.dp))
                            innerTextField()
                        }
                    }



                }
            }
        )
        Button(
            modifier = Modifier
                .height(45.dp)
                .weight(1f)
                .padding(start = 5.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonColors(
                containerColor = DefaultSearchBar,
                contentColor = Color.Black,
                disabledContentColor = Color.Black,
                disabledContainerColor = DefaultSearchBar
            ),
            onClick = {
                if (ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.RECORD_AUDIO
                    ) == PackageManager.PERMISSION_GRANTED
                ) {
                    val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    intent.putExtra(
                        RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                        RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
                    )
                    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
                    intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "음성인식 중..")
                    speechRecognizerLauncher.launch(intent)
                } else {
                    ActivityCompat.requestPermissions(
                        context as Activity,
                        arrayOf(Manifest.permission.RECORD_AUDIO),
                        100
                    )
                }
            },

            ){
            Icon(
                modifier = Modifier.size(20.dp),
                imageVector = ImageVector.vectorResource(R.drawable.mic),
                contentDescription = "음성검색",
            )
        }
    }
}

