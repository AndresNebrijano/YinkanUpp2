package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.yinkanupp.navigation.AppScreens

//función para lanzar la página de login de usuario
@Composable
fun Login(navController: NavHostController){

    val nombreUsuario = "Santiago Manuel"
    val passwordUsuario = "erarcardehija"
    var enabled by remember { mutableStateOf(false) }

    //Columna general dentro de la que van a ir los elementos de la vista, la cual define
    //la imagen de fondo
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )){

        //Columna para el banner del header
        Column(){
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .fillMaxWidth(),

            )
        }
        //Columna para situar las cajas de texto
        Column(modifier = Modifier.padding(top = 50.dp)) {

            //llamamos 2 veces a la función RellenarDatosUsuario para pintar en pantalla
            //los 2 MyText donde introducir los textos
            var nombreUsuario2 = rellenarDatosUsuario(text = "Nombre")
            var passwordUsuario2 = rellenarDatosUsuario(text = "Password")

            if ((nombreUsuario == nombreUsuario2) && (passwordUsuario == passwordUsuario2)){
                enabled = true
            }
        }

        ExtendedFloatingActionButton(
            onClick = {if (enabled) {navController.navigate(AppScreens.IniciarGymkana.ruta)}},
            icon = {
            },
            text = { Text ("Login") },
            modifier = Modifier
                .padding(top = 60.dp)
        )
    }
}
