package com.augusto.bigball.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun Loading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = MaterialTheme.colors.secondary)
    }
}

@Composable
fun InputText(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
    error: String? = null,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value ?: "",
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White, textColor = Color.Black),
        maxLines = 1,
        visualTransformation = visualTransformation,
        label = {
            Text(
                text = if (!error.isNullOrEmpty()) error
                else label
            )
        },
        enabled = enabled,
        isError = !error.isNullOrEmpty(),
    )
}

@Composable
fun PrimaryButton(modifier: Modifier, text: String, enabled: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text = text)
    }
}