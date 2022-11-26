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
import androidx.navigation.NavHostController

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
            val bannerhead = painterResource(R.drawable.banner)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)

            )
        }
        
        ColocarBotones(text = "Nueva gymkana", separacion = 110)
        ColocarBotones(text = "Continuar gymkana", separacion = 95)
    }
}

@Composable
fun ColocarBotones(text: String, separacion: Int){

    ExtendedFloatingActionButton(
        onClick = { },
        icon = {
        },
        text = { Text (text) },
        modifier = Modifier
            .padding(top = 200.dp, start = separacion.dp)
    )
}