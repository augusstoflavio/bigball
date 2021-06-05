package com.augusto.bigball.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


val Green700 = Color(0xff2e7c31)
val Green800 = Color(0xff60ad5e)
val Green900 = Color(0xff60ac5d)
val Yellow700 = Color(0xffffd600)
val YellowVariant = Color(0xffffff52)
val RedError = Color(0xffb71c1c)

private val LightColors = lightColors(
    primary = Green700,
    primaryVariant = Green900,
    onPrimary = Color.White,
    secondary = Yellow700,
    secondaryVariant = YellowVariant,
    onSecondary = Color.Black,
    error = RedError
)

@Composable
fun BigBallTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColors,
        content = content
    )
}