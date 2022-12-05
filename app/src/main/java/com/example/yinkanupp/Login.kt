package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
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
    //Columna general dentro de la que van a ir los elementos de la vista, la cual define
    //la imagen de fondo
    Column(
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
            RellenarDatosUsuario(text = "Nombre")
            RellenarDatosUsuario(text = "Password")

            //llamamos a la función ColocarBotones para pintar el botón de Login
            ColocarBotones(text = "Login", separacionTop = 60, separacionStart = 140, navController, ruta = AppScreens.IniciarGymkana.ruta )

        }
    }



}
