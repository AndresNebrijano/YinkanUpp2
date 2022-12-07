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

//función para lanzar la página de registro de usuario
@Composable
fun Formulario(navController: NavHostController){

    var enabled by remember { mutableStateOf(false) }
    var mostrarAlerta by remember { mutableStateOf(false) }
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
                    .fillMaxWidth()

            )
        }
        //Columna para situar las 3 cajas de texto
        Column(modifier = Modifier.padding(top = 50.dp)) {

            //llamamos 3 veces a la función RellenarDatosUsuario para pintar en pantalla
            //los 3 MyText donde introducir los textos
            var nombreRegistro=rellenarDatosUsuario(text = "Nombre")
            var correoRegistro=rellenarDatosUsuario(text = "Correo")
            var paswordRegistro=rellenarDatosUsuario(text = "Password")

            if ((!nombreRegistro.isEmpty()) && (!correoRegistro.isEmpty()) && (!paswordRegistro.isEmpty())){
                enabled = true
            }
        }
        ExtendedFloatingActionButton(
            onClick = {if (enabled) {
                navController.navigate(AppScreens.IniciarGymkana.ruta)
            }else{
                mostrarAlerta = true
            }
            },
            icon = {
            },
            text = { Text ("Registrar") },
            modifier = Modifier
                .padding(top = 60.dp)
        )
    }

    if (mostrarAlerta) {
        AlertDialog(
            onDismissRequest = { mostrarAlerta = false },
            title = { Text(text = "Todos los campos son obligatorios") },
            text = { Text(text = "Por favor, rellene los campos") },
            confirmButton = {
                Button(onClick = { mostrarAlerta = false },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.LightGray)
                ) {
                    Text(text = "Confirmar", color = Color.Blue)
                }
            }
        )
    }


}

//función para crear las cajas de texto donde va a ir el registro de usuario
@Composable
fun rellenarDatosUsuario(text: String): String {

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

    return myText
}
