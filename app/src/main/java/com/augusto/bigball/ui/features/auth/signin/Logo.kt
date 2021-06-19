package com.augusto.bigball.ui.features.auth.signin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.augusto.bigball.R


@Composable
fun Logo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.bolao_2021),
            style = MaterialTheme.typography.h5
        )

        Spacer(modifier = Modifier.height(8.dp))

        Image(
            painter = painterResource(R.drawable.ic_futebol_1),
            contentDescription = "Logo"
        )
    }
}