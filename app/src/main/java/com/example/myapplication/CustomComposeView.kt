package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@Composable
fun InfoCard() {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Property Name
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "物件名稱",
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = "imac 實驗室",
                    fontSize = 16.sp,
                    color = Color.Black
                )
            }

            // Divider
            Divider(
                color = Color(0xFF9C27B0),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            // Usage Period
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "使用期間",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = "2021/11/23–2021/12/01",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            // Expiry Notification
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "逾期通知",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Text(
                    text = "2021/12/01",
                    fontSize = 14.sp,
                    color = Color.Black
                )
            }

            // Account Number with Copy Icon
            val clipboardManager: ClipboardManager = LocalClipboardManager.current
            val accountNumber = remember { TextFieldValue("#v23Db") }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
//                        clipboardManager.setText(accountNumber)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "帳單編號",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = accountNumber.text,
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                    IconButton(onClick = {
//                        clipboardManager.setText(accountNumber)
                    }) {
                        Icon(
                            imageVector = Icons.Default.Build,
                            contentDescription = "Copy",
                            tint = Color.Black
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TestCardWide() {
    val backgroundColor = colorResource(id = R.color.purple_500)

    Card(
        colors = CardDefaults.cardColors(
            backgroundColor
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Column(
            Modifier.padding(8.dp)
        ) {
            TestCard(titleText = "測試開頭", contentText = "測試結束")
            Divider(
                color = Color(0xFF9C27B0),
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TestCard(
                titleText = "測試開頭",
                contentText = "測試結束",
                contentImage = ImagePosition.None()
            )
        }
    }

}

@Composable
fun TestCard(
    titleText: String = "", contentText: String = "",
    titleTextSize: Int = R.dimen.text_size_large,
    contentTextSize: Int = R.dimen.text_size_large,
    paddingVertical: Int = R.dimen.text_size_12,
    paddingHorizontal: Int = R.dimen.text_size_12,
    titleImage: ImagePosition = ImagePosition.Left(
        android.R.drawable.ic_delete, padding = R.dimen.text_size_large
    ), contentImage: ImagePosition = ImagePosition.Right(
        android.R.drawable.ic_delete, padding = R.dimen.text_size_large
    ),
    onRowClick: (() -> Unit)? = null,
    onLeftRowClick: (() -> Unit)? = null,  // 左侧图像的点击事件
    onRightRowClick: (() -> Unit)? = null, // 右侧图像的点击事件
    enablePointerInput: Boolean = true  // 是否启用 pointerInput 的开关
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = dimensionResource(id = paddingHorizontal),
                    vertical = dimensionResource(id = paddingVertical)
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TestImgRow(
                modifier = Modifier.wrapContentSize(),
                contentText = titleText, contentTextSize = titleTextSize,
                imagePosition = titleImage
            )

            TestImgRow(
                modifier = Modifier.weight(1f),
                contentText = contentText, contentTextSize = contentTextSize,
                imagePosition = contentImage
            )


        }
    }


}

sealed class ImagePosition {
    data class None(
        val padding: Int = R.dimen.text_size_40
    ) : ImagePosition()

    data class Left(
        val leftImageResId: Int, val size: Int? = null,
        val padding: Int = R.dimen.text_size_40
    ) : ImagePosition()

    data class Right(
        val rightImageResId: Int, val size: Int? = null,
        val padding: Int = R.dimen.text_size_40
    ) : ImagePosition()

    data class Both(
        val leftImageResId: Int,
        val rightImageResId: Int,
        val leftSize: Int? = null,
        val rightSize: Int? = null,
        val padding: Int = R.dimen.text_size_40
    ) : ImagePosition()
}

@Composable
fun TestImgRow(
    contentText: String = "",
    contentTextSize: Int = R.dimen.text_size_large,
    modifier: Modifier,
    imagePosition: ImagePosition = ImagePosition.Both(
        android.R.drawable.ic_menu_camera, android.R.drawable.ic_menu_camera
    ),
    onRowClick: (() -> Unit)? = null,
    onLeftImageClick: (() -> Unit)? = null,
    onRightImageClick: (() -> Unit)? = null
) {
    val leftImageWidth = when (imagePosition) {
        is ImagePosition.Left -> {
            imagePosition.size?.let { dimensionResource(id = it).value } ?: 0f
        }

        is ImagePosition.Both -> {
            imagePosition.leftSize?.let { dimensionResource(id = it).value } ?: 0f
        }

        else -> 0f
    }

    val rightImageWidth =
        when (imagePosition) {
            is ImagePosition.Right -> {
                imagePosition.size?.let { dimensionResource(id = it).value } ?: 0f
            }

            is ImagePosition.Both -> {
                imagePosition.rightSize?.let { dimensionResource(id = it).value } ?: 0f
            }

            else -> 0f
        }
    Row(
        modifier = Modifier
            .then(modifier)
            .pointerInput(Unit) {
                detectTapGestures { offset ->
                    when {
                        offset.x <= leftImageWidth && onLeftImageClick != null -> onLeftImageClick.invoke()
                        offset.x >= size.width - rightImageWidth && onRightImageClick != null -> onRightImageClick.invoke()
                        onRowClick != null -> onRowClick.invoke()
                    }
                }
            },
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (imagePosition is ImagePosition.Left || imagePosition is ImagePosition.Both) {
            DrawImage(imagePosition, isLeft = true)
        }
        Text(
            text = contentText,
            fontSize = dimensionResource(id = contentTextSize).value.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Right,
            softWrap = false,
        )
        if (imagePosition is ImagePosition.Right || imagePosition is ImagePosition.Both) {
            DrawImage(imagePosition, isLeft = false)
        }
    }
}

@Composable
fun DrawImage(imagePosition: ImagePosition, isLeft: Boolean) {
    val imageResId: Int
    val sizeId: Int?
    val paddingId: Int

    when (imagePosition) {
        is ImagePosition.Left -> {
            imageResId = imagePosition.leftImageResId
            sizeId = imagePosition.size
            paddingId = imagePosition.padding
        }

        is ImagePosition.Right -> {
            imageResId = imagePosition.rightImageResId
            sizeId = imagePosition.size
            paddingId = imagePosition.padding
        }

        is ImagePosition.Both -> {
            if (isLeft) {
                imageResId = imagePosition.leftImageResId
                sizeId = imagePosition.leftSize
            } else {
                imageResId = imagePosition.rightImageResId
                sizeId = imagePosition.rightSize
            }
            paddingId = imagePosition.padding
        }

        is ImagePosition.None -> return
    }

    val sizeDp = sizeId?.let { dimensionResource(id = it) } ?: Dp.Unspecified
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = null,
        modifier = Modifier
            .then(
                if (sizeDp != Dp.Unspecified) {
                    Modifier.size(sizeDp)
                } else {
                    Modifier.wrapContentSize()
                }
            )
            .padding(
                end = if (isLeft) dimensionResource(id = paddingId) else 0.dp,
                start = if (!isLeft) dimensionResource(id = paddingId) else 0.dp,
            )
            .background(Color.Gray)
    )
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview2() {
    MaterialTheme {
        Surface {
            Row {
                TestCardWide()

            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    MaterialTheme {
        Surface {
            Row {
                InfoCard()

            }

        }
    }
}

val TAG = "a0809"

@Composable
fun Foo() {
    var text by remember { mutableStateOf("") }
    Log.d(TAG, "Foo")
    Button(onClick = {
        text = "$text $text"
    }.also { Log.d(TAG, "Button") }) {
        Log.d(TAG, "Button content lambda")
        Text(text).also { Log.d(TAG, "Text") }
    }

    Button(onClick = { /*TODO*/ }) {

    }
}

class Ref(var value: Int)

@Composable
inline fun LogCompositions(msg: String) {
    val ref = remember { Ref(0) }
    SideEffect { ref.value++ }
    Log.d("RecompositionLog", "Compositions: $msg ${ref.value}")
}

//@Composable
//fun Greeting() {
////    var state by remember {
////        mutableStateOf("Hi Foo")
////    }
////    LogCompositions(msg = "Greeting Scope")
////
////    Column {
////        LogCompositions(msg = "Column Scope")
////        Button(
////            onClick = { state = "Hi Foo ${Random.nextInt()}" },
////            modifier = Modifier
////                .padding(top = 32.dp)
////        ) {
////            LogCompositions(msg = "Button Scope")
////            Text(
////                text = "Click Me!"
////            )
////            Text(text = state)
////        }
////    }
//    var state by remember {
//        mutableStateOf("Hi Foo")
//    }
//    LogCompositions(msg = "Greeting Scope")
//    Column { // We add new component here
//        LogCompositions(msg = "Column Scope")
//        Text(text = state)
//        Button(
//            onClick = { state = "Hi Foo ${Random.nextInt()}" },
//        ) {
//            LogCompositions(msg = "Button Scope")
//            Text(
//                text = "Click Me"
//            )
//        }
//    }
//
//
//}
@Composable
fun Greeting() {
    var state by remember {
        mutableStateOf("Hi Foo")
    }
    var staticState by remember {
        mutableStateOf("This state never changes")
    }
    LogCompositions(msg = "Greeting Scope")
    Column {
        LogCompositions(msg = "Column Scope")
        Text(text = state)
        Text(text = staticState)
        Button(
            onClick = { state = "Hi Foo ${Random.nextInt()}" },
        ) {
            LogCompositions(msg = "Button Scope")
            Text(
                text = "Click Me"
            )
        }
        Text(text = "CABD")
    }
}


@Composable
fun MyComponent() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("MyComposable function")

    CustomText(
        text = "Counter: $counter",
        modifier = Modifier
            .clickable {
                counter++
            },
    )
}

@Composable
fun MyComponent2() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("MyComposable function")

    Button(onClick = { counter++ }) {
        LogCompositions("Button")
        CustomText(
            text = "Counter: $counter",

            )
    }
}

@Composable
fun MyComponent3() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("MyComposable function")

    val readingCounter = counter
    CustomButton(onClick = { counter++ }) {
        LogCompositions("CustomButton scope")
        CustomText(
            text = "Counter: $counter",
            modifier = Modifier
                .clickable {
                    counter++
                },
        )
    }
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    LogCompositions("CustomButton CustomTest2  function")
    Button(
        onClick = onClick, modifier = Modifier
            .padding(16.dp)
            .then(Modifier.randomColorBg())
    ) {
        LogCompositions("Button CustomTest2 function")
        Text(text = "hello", modifier = Modifier.randomColorBg())
        content()
    }
}

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
) {
    LogCompositions("CustomText function")

    Text(
        text = text,
        modifier = modifier.padding(32.dp),
        style = TextStyle(
            fontSize = 20.sp,
            textDecoration = TextDecoration.Underline,
            fontFamily = FontFamily.Monospace
        )
    )
}

@Composable
fun CustomTest() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("MyComposable function")

    Button(onClick = {
        counter += 1
    }, modifier = Modifier.padding(16.dp)) {
        LogCompositions("Button function")
        Text(text = "hello")
        counter
//        content(counter)
    }

}

@Composable
fun content(counter: Int) {
    LogCompositions("content function")

    var c = counter
}


@Composable
fun CustomTest2() {
    var counter by remember { mutableStateOf(0) }

    LogCompositions("MyComposable CustomTest2  function")

    CustomButton(onClick = {
        counter += 1
    }) {
        LogCompositions("Button CustomTest2 function")
        Text(text = "hello")
        content(counter)
    }

}

@Composable
fun CustomTest5() {
    var counter by remember { mutableStateOf(0) }

    CustomButton(onClick = { counter += 1 }) {
        LogCompositions("Button 第一層")
        Text(text = "abc", modifier = Modifier.randomColorBg())
        StaticText()  // 不依赖 counter 的内容
        CounterText(counter)  // 依赖 counter 的内容
    }
}

@Composable
fun RandomColorColumn(content: @Composable () -> Unit) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
            .then(Modifier.randomColorBg())
            .padding(4.dp)
    ) {
        content()
    }
}

@Composable
fun Demo() {
    var count by remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.randomColorBg()) {
        Text(
            modifier = Modifier.randomColorBg(),
            text = "count = $count"
        )
        CustomButton(onClick = { count++ }) {
            Button(
                modifier = Modifier.randomColorBg(),
                onClick = { count++ }
            ) {
                Text(
                    modifier = Modifier.randomColorBg(),
                    text = "Increase"
                )
            }
        }

    }
}

fun getRandomColor() = Color(
    red = Random.nextInt(256),
    green = Random.nextInt(256),
    blue = Random.nextInt(256),
    alpha = 255
)

@Composable
fun MyText(counter: Int) {
    Column {
        Text(
            "MyText: counter: $counter",
            color = Color.White,
            modifier = Modifier.background(getRandomColor())
        )
        Text("Another Text", color = Color.White, modifier = Modifier.background(getRandomColor()))
    }
}

data class Hero(val name: String, val age: Int)
data class Hero2(var name: String, var age: Int)

val shangDan = Hero("吕布", 0)

@Composable
fun HeroInfo() {
    val heroList = remember {
        mutableStateListOf(Hero(name = "安其拉", age = 18), Hero(name = "鲁班", age = 19))
    }

//    Column {
//        Button(onClick = {
//            heroList[0].name = "DaJi"
//            heroList[0].age = 22
//        }) {
//            Text(text = "test click")
//        }
//
//        heroList.forEach {
//            Text(text = "student, name: ${it.name}, age: ${it.age} ")
//        }
//    }
}

@Composable
public fun Content() {
    var number by remember { mutableStateOf(0) }
    // 用户信息
    val user = remember { User() }

    Column(Modifier.randomColorBg()) {
        Text(
            text = number.toString(),
            modifier = Modifier
                .clickable {
                    number++
                }
                .padding(10.dp)
                .then(Modifier.randomColorBg())
        )

        // 用户信息
        UserInfo(user = user)
    }
}

@Composable
private fun UserInfo(user: User) {
    Text(text = user.name, Modifier.randomColorBg())
}

class User(
    val name: String = "default"
)


@Composable
fun StableTest() {
    var greeting by remember {
        mutableStateOf("hello, 鲁班")
    }

    Column(Modifier.randomColorBg()) {
        Log.i("sharpcj", "invoke --> 1")
        //這同層會被影響
        Text(text = "jx", Modifier.randomColorBg())
        Text(text = greeting, Modifier.randomColorBg())
        var hero1 = Hero("吕布", 0)
        var hero2 = Hero2("吕布", 0)

        Button(onClick = {
            greeting = "hello, 鲁班大师 ${Random.nextInt()}"
            hero1 = Hero("valj", 0)
            hero2 = Hero2("kyc", Random.nextInt())
        }, Modifier.randomColorBg()) {
            Text(text = "搞错了，是鲁班大师", Modifier.randomColorBg())
        }
        //compose 所以不被影響然後ｄａｔａ class要都是val
        //不然屬性沒變看不出來
        ShangDan(shangDan)
        ShangDan(hero1)
        ShangDan2(hero2)

    }
}


@Composable
fun CoffeeSelector(
    type: Type,
    onTypeChange: (Type) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(getRandomColor()),
            contentAlignment = Alignment.Center
        ) {
            val text = when (type) {
                Type.BIG -> "大杯"
                Type.MIDDLE -> "中杯"
                Type.SMALL -> "小杯"
            }
            Text(text = text, fontSize = 16.sp, color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column {
            MyButton("大杯") {
                onTypeChange(Type.BIG)
            }
            MyButton("中杯") {
                onTypeChange(Type.MIDDLE)
            }
            MyButton("小杯") {
                onTypeChange(Type.SMALL)
            }
        }
    }
}

@Composable
fun MyButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(getRandomColor()),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    }
}

enum class Type { BIG, MIDDLE, SMALL }

@Composable
fun ShangDan2(hero: Hero2) {
    Log.i("sharpcj", "invoke --> 2")
    Text(text = hero.name+"-${hero.age}", Modifier.randomColorBg())
}

@Composable
fun ShangDan(hero: Hero) {
    Log.i("sharpcj", "invoke --> 2")
    Text(text = hero.name+"-${hero.age}", Modifier.randomColorBg())
}

//todo https://juejin.cn/post/7325338405409587252
//todo https://mp.weixin.qq.com/s/U8vYckZLX3xjxFJk100Xxw
@Composable
fun Sample() {

    //1.  column那種inline都是會攤平的 會影響到其他層,可以改用compose函數解決.Card不是 column row box都是
    //2. 讀取或var 會影響函數 即使只是println(var) 也會影響 ,
    //3. button 內也是rowscope 所以button 有 Ａ,B Ａ變化Ｂ也變 除非再套一層composable函數 （飛inline)


//    Column(
//        modifier = Modifier
//            .wrapContentSize()
//            .padding(4.dp)
//            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
//            .background(getRandomColor())
//            .padding(4.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        var counter by remember { mutableStateOf(0) }
//        Text("Text1", color = Color.White, modifier = Modifier.background(getRandomColor()))
//        Button(
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors( getRandomColor()),
//            onClick = { counter++ },
//            shape = RoundedCornerShape(5.dp)
//        ) {
//            Text("Text2",Modifier.randomColorBg())
//            Text("Text2: counter: $counter", color = Color.White, modifier = Modifier.background(getRandomColor()))
//            MyText(counter)
//        }
//    }
//    Column(
//        modifier = Modifier
//            .padding(4.dp)
//            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
//            .background(getRandomColor())
//            .padding(4.dp)
//    ) {
//        var update1 by remember { mutableStateOf(0) }
//
//        println("ROOT")
//        Text("Text in outer Column", color = Color.White, modifier = Modifier.background(getRandomColor()))
//
//        Button(
//            modifier = Modifier.fillMaxWidth(),
//            colors = ButtonDefaults.buttonColors( getRandomColor()),
//            onClick = { update1++ },
//            shape = RoundedCornerShape(5.dp)
//        ) {
//            println("🔥 Button 1")
//            Text(
//                text = "Text in Button1 read update1: $update1",
//                textAlign = TextAlign.Center,
//                color = Color.White,
//                modifier = Modifier.background(getRandomColor())
//            )
//        }
//
//        Column(
//            modifier = Modifier
//                .padding(4.dp)
//                .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
//                .background(getRandomColor())
//                .padding(4.dp)
//        ) {
//            println("🚀 Inner Column")
//            var update2 by remember { mutableStateOf(0) }
//            Button(
//                modifier = Modifier.fillMaxWidth(),
//                colors = ButtonDefaults.buttonColors( getRandomColor()),
//                onClick = { update2++ },
//                shape = RoundedCornerShape(5.dp)
//            ) {
//                println("✅ Button 2")
//                Text(
//                    text = "Text in Button2 read update2: $update2",
//                    textAlign = TextAlign.Center,
//                    color = Color.White,
//                    modifier = Modifier.background(getRandomColor())
//                )
//            }
//
//            Column(
//                modifier = Modifier
//                    .padding(4.dp)
//                    .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
//                    .background(getRandomColor())
//                    .padding(6.dp)
//            ) {
//                println("☕ Bottom Column")
////                /**
////                 * 🔥🔥 Observing update(mutableState) causes entire composable to recompose
////                 */
//                RandomColorColumn() {
//                                    Text(
//                    text = "🔥 Text in Inner Column read update1: $update1",
//                    textAlign = TextAlign.Center,
//                    color = Color.White,
//                    modifier = Modifier.background(getRandomColor())
//                )
//
//                }
//            }
//        }
//    }

    Column(
        modifier = Modifier
            .padding(4.dp)
            .shadow(1.dp, shape = CutCornerShape(topEnd = 8.dp))
            .then(Modifier.randomColorBg())
            .padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var myData = 0

        var counter by remember { mutableStateOf(0) }
        Text(
            "Text1 Read counter: $counter",
            color = Color.White,
            modifier = Modifier.randomColorBg()
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .then(Modifier.randomColorBg()),
            onClick = {
                counter++
                myData++
            },
            colors = ButtonDefaults.buttonColors(generateRandomColor()),
            shape = RoundedCornerShape(5.dp)
        ) {
            Column {
                Text("Text2", color = Color.White, modifier = Modifier.randomColorBg())
//            Text("Text2 Read myData.value: ${myData}", color = Color.White, modifier = Modifier.background(
//                generateRandomColor()
//            ))
                SomeComposable()
//                Surface(modifier = Modifier.randomColorBg()) {
//                    Text("Text4", color = Color.White, modifier =Modifier.randomColorBg())
//
//
//                }
                println(myData)

                println("cas")
            }
            SomeComposable()
            RandomColorColumn {
                Text("Text2 ", color = Color.White, modifier = Modifier.randomColorBg())
                Text("Text3 : $myData", color = Color.White, modifier = Modifier.randomColorBg())
                RandomColorColumn {
                    Text(text = "a", modifier = Modifier.randomColorBg())
                }
            }

        }
    }
}

@Composable
private fun SomeComposable() {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .shadow(1.dp, shape = CutCornerShape(topEnd = 6.dp))
            .background(generateRandomColor())
            .padding(4.dp)
    ) {
        Text(
            "some compose", color = Color.White, modifier = Modifier.background(
                generateRandomColor()
            )
        )
    }
}

@Composable
fun StaticText() {
    LogCompositions("StaticText 第一層")

    Text(text = "Hello", modifier = Modifier.randomColorBg())
}

@Composable
fun CounterText(counter: Int) {
    LogCompositions("CounterText 第一層")

    Text(text = "Counter: $counter", modifier = Modifier.randomColorBg())
}

@Preview
@Composable
fun PrevFoo() {
    Foo()
}

fun generateRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1.0f
    )
}

// Step 2: 扩展 Modifier
fun Modifier.randomColorBg(): Modifier = this.then(
    background(generateRandomColor())
)

@Composable
fun String.Log(block: () -> String) {
    SideEffect {
        Log.d(this, block())
    }
}

data class Test(var name: String, var age: Int)

@Composable
fun HeroInfoWithVar() {
    val hero = mutableStateOf(Test(name = "安其拉", age = 18))

    Column {
        Button(onClick = {
            hero.value.name = "DaJi"
            hero.value.age = Random.nextInt()
        }, Modifier.randomColorBg()) {
            Text(text = "test click", Modifier.randomColorBg())
        }

        Text(
            text = "student, name: ${hero.value.name}, age: ${hero.value.age} ",
            Modifier.randomColorBg()
        )
    }
}

@Composable
fun HeroInfoWithVarRemember() {
    // 使用 remember 将 hero 存储在记忆中，只会初始化一次
    //mutableStateOf 仅监视对 hero.value 本身的变化，而不监视 hero.value 内部属性的变化。
    val hero = remember { mutableStateOf(Test(name = "安其拉", age = 18)) }

    Column(Modifier.randomColorBg()) {
        Button(onClick = {
            hero.value.name = "DaJi"
            hero.value.age = Random.nextInt()
        }, Modifier.randomColorBg()) {
            Text(text = "test click", Modifier.randomColorBg())
        }

        Text(
            text = "Ｖar, name: ${hero.value.name}, age: ${hero.value.age} ",
            Modifier.randomColorBg()
        )
    }
}

@Composable
fun HeroInfoWithVal() {
    val hero = remember { mutableStateOf(Test(name = "安其拉", age = 18)) }

    Column(Modifier.randomColorBg()) {
        Button(onClick = {
            hero.value = Test(name = "DaJi", age =   Random.nextInt())  // 使用 copy 创建一个新的对象
        }) {
            Text(text = "test click", Modifier.randomColorBg())
        }

        Text(
            text = "val, name: ${hero.value.name}, age: ${hero.value.age} ",
            Modifier.randomColorBg()
        )
    }
}