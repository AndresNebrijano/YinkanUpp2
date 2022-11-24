package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Formulario(navController: NavHostController){
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

        Column(modifier = Modifier.padding(top = 50.dp)) {

            var myText by remember { mutableStateOf("") }
            OutlinedTextField(
                value= myText,
                onValueChange = {myText = it },
                modifier = Modifier.padding(50.dp,20.dp).background(color = Color.White.copy(alpha = 0.4f)),
                label = { Text(text = "Nombre", color = Color.Black, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue
                )
            )

            var myText2 by remember { mutableStateOf("") }
            OutlinedTextField(
                value= myText,
                onValueChange = {myText = it },
                modifier = Modifier.padding(50.dp,20.dp).background(color = Color.White.copy(alpha = 0.4f)),
                label = { Text(text = "Apellidos", color = Color.Black, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue
                )
            )

            var myText3 by remember { mutableStateOf("") }
            OutlinedTextField(
                value= myText,
                onValueChange = {myText = it },
                modifier = Modifier.padding(50.dp,20.dp).background(color = Color.White.copy(alpha = 0.4f)),
                label = { Text(text = "Curso", color = Color.Black, fontWeight = FontWeight.Bold) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.Blue
                )
            )
        }
    }



}
