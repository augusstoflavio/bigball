package com.augusto.bigball.presentation

import android.app.AlertDialog
import android.widget.AutoCompleteTextView
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.augusto.bigball.ui.features.auth.signin.SigninEvent

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
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value ?: "",
        onValueChange = onValueChange,
        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White, textColor = Color.Black),
        maxLines = 1,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
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
fun InputEmail(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
    error: String? = null,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true
) {
    InputText(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        label = label,
        enabled = enabled,
        error = error
    )
}

@Composable
fun InputPassword(
    modifier: Modifier = Modifier,
    label: String,
    value: String?,
    error: String? = null,
    onValueChange: (String) -> Unit,
    enabled: Boolean = true
) {
    InputText(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        label = label,
        enabled = enabled,
        error = error
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

@Composable
fun ErrorDialog(title: String, message: String, onDismissRequest: () -> Unit) {
    AlertDialog(onDismissRequest = onDismissRequest,
        title = {
        Text(text = title)
    }, text = {
        Text(
            text = message
        )
    }, buttons = {
        Box(modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, bottom = 20.dp)) {
            Button(onClick = onDismissRequest) {
                Text(text = "Ok")
            }
        }
    })
}