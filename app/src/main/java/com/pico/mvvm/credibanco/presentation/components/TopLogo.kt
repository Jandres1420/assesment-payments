package com.pico.mvvm.credibanco.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.pico.mvvm.credibanco.R
import com.pico.mvvm.credibanco.ui.theme.Purple80

@Composable
fun TopLogo() {

    Box(
        modifier = Modifier.fillMaxWidth().background(Purple80),
    )  {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        ){
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,)  {
                Image(modifier = Modifier.height(180.dp),
                    painter = painterResource(id = R.drawable.logo)
                    , contentDescription = "CrediBanco logo")
            }
        }

    }
}