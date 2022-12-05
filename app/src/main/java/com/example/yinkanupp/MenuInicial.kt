package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.yinkanupp.navigation.AppScreens

@Composable
fun MostrarMenuInicial(navController: NavHostController){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )){

        Column(){
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)

            )
        }

        ColocarBotones(text = "Registrar usuario", separacionTop = 110, separacionStart = 110, navController, ruta = AppScreens.Formulario.ruta )
        ColocarBotones(text = "Iniciar sesión", separacionTop = 120, separacionStart = 120, navController, ruta = AppScreens.Login.ruta)
    }
}

@Composable
fun ColocarBotones(text: String, separacionTop: Int, separacionStart: Int, navController: NavHostController, ruta: String){

    ExtendedFloatingActionButton(
        onClick = {navController.navigate(ruta)},
        icon = {
        },
        text = { Text (text) },
        modifier = Modifier
            .padding(top = separacionTop.dp, start = separacionStart.dp)
    )
}