package com.pico.mvvm.credibanco.presentation.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.pico.mvvm.credibanco.presentation.components.DefaultButton
import com.pico.mvvm.credibanco.presentation.navigation.AppScreen
import com.pico.mvvm.credibanco.ui.theme.Purple80

@Composable
fun HomeContent(navController: NavHostController){

    Card(
        modifier = Modifier.padding(start = 30.dp, end = 30.dp, top = 50.dp),
        backgroundColor = Purple80
    ) {
        Column(modifier = Modifier.padding(horizontal = 20.dp)) {
            Text(
                modifier = Modifier.padding(top = 30.dp, bottom = 0.dp, start = 0.dp, end = 0.dp),
                text = "INICIO",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Por favor de click en algun boton para continuar", fontSize = 12.sp,
                color = Color.Gray
            )

            DefaultButton(
                text = "Autorización de transacciones",
                onClick = {navController.navigate(route = AppScreen.Authorization.route)},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            DefaultButton(
                text = "Busqueda transacciones aprobadas por número de recibo",
                onClick = {navController.navigate(route = AppScreen.SearchAuth.route)},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            DefaultButton(
                text = "Listado de todas las transacciones aprobadas",
                onClick = {navController.navigate(route = AppScreen.ListApprove.route)},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
            DefaultButton(
                text = "Anulación de transacciones por número de recibo",
                onClick = {navController.navigate(route = AppScreen.Annulment.route)},
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultHomeContentPreview() {
    var navController: NavHostController = rememberNavController()
    HomeContent(navController)
}