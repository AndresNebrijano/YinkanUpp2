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

//función para lanzar la página de inicio de sesión de usuario
@Composable
fun Formulario(navController: NavHostController){
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
        //Columna para situar las 3 cajas de texto
        Column(modifier = Modifier.padding(top = 50.dp)) {

            //llamamos 3 veces a la función RellenarDatosUsuario para pintar en pantalla
            //los 3 MyText donde introducir los textos
            RellenarDatosUsuario(text = "Caca")
            RellenarDatosUsuario(text = "Apellidos")
            RellenarDatosUsuario(text = "Curso")



            ExtendedFloatingActionButton(
                onClick = { navController.navigate("pantalla2") },
                icon = {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = "Favorite"
                    )
                },
                text = { Text("Cambiar") }
            )
        }
    }



}

@Composable
fun RellenarDatosUsuario(text: String){

    var myText by remember { mutableStateOf("") }
    OutlinedTextField(
        value= myText,
        onValueChange = {myText = it },
        modifier = Modifier
            .padding(50.dp, 20.dp)
            .background(color = Color.White.copy(alpha = 0.4f)),
        label = { Text(text = text, color = Color.Black, fontWeight = FontWeight.Bold) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Magenta,
            unfocusedBorderColor = Color.Blue
        )
    )
}
