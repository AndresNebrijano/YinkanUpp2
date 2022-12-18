package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun IniciarGymkana(navController: NavHostController){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
            .verticalScroll(rememberScrollState()),
    ){

        Column(){
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth()

            )
        }
        if (nombreUsuario == "") {
            Text(text = "¡¡¡Bienvenido/a $nombreUsuarioRegistro!!!", color = Color.White)
        }else {
            Text(text = "¡¡¡Bienvenido/a $nombreUsuario!!!", color = Color.White)
        }

        ColocarBotones(text = "Nueva Gymkana", separacion = 60, navController, ruta = AppScreens.ElegirGymkana.ruta )
        ColocarBotones(text = "Continuar Gymkana", separacion = 60, navController, ruta = AppScreens.ElegirGymkana.ruta)
    }
}