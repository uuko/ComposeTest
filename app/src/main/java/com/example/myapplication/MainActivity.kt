package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("A")
//                    CustomTest()
//                    Sample()
//                    HeroInfo()
//                    StableTest()
//                    Content()
//                    CustomTest5()
//                    MainScreen(viewModel)

                    Column {
                        Card {
                            HeroInfoWithVar()
                        }
                        Card {
                            HeroInfoWithVal()
                        }
                        Card {
                            HeroInfoWithVarRemember()
                        }

                        Card {
                            StableTest()
                        }
                    }

                }
            }
        }

        lifecycleScope.launch {
            delay(3000)
            nameMutable.value="3s hellow"
        }
    }
}
private val nameMutable = mutableStateOf("hellow")
//通用用modifier 專項的用函數參數
//預設是wrap_content ,fillMaxHeight = match_parent
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Row (modifier= modifier
        .background(Color.White)
        ){
            Text(
                text =nameMutable.value,
                modifier = Modifier
                    .padding(16.dp)
                    .background(Color.Yellow)

                    .padding(32.dp)
                    .clickable {
                        Log.e("TAG", "Greeting: ABC",)
                    },
                fontSize = 22.sp
            )
//        Button(onClick = {}) {
//
//        }
        }
//        Column( modifier= modifier
//            .background(Color.Blue)
//            .padding(4.dp)){
//
//            Text(
//                text = "Hello $name!", color = Color.White,
//                modifier = modifier
//                    .padding(horizontal = 16.dp, vertical = 16.dp)
//                    .background(Color.Magenta)
//            )
//        }
//        Column( modifier= modifier
//            .background(Color.Blue)
//            .padding(4.dp)){
//
//            Text(
//                text = "Hello $name!", color = Color.White,
//                modifier = modifier
//                    .padding(horizontal = 16.dp, vertical = 16.dp)
//                    .background(Color.Magenta)
//            )
//        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("A")
    }
}