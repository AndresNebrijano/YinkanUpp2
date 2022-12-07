package com.example.yinkanupp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Resultado (navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
            .verticalScroll(rememberScrollState())
    ) {

        Column {
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()

            )

            if(contador <5 ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.i5),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contador puntos, es un poco triste..... ",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contador >=5 && contador <10){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.i10),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contador puntos, nos vamos acercando ",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contador >=10 && contador <15) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp, 50.dp)
                        .border(width = 8.dp, color = Color.Cyan)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(
                        painter = painterResource(R.drawable.i15),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp, 30.dp))
                    Text(
                        text = " Has obtenido $contador puntos, eres simplemente apto ",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp, 20.dp, 25.dp, 20.dp)
                    )
                }
            }else{
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp,50.dp)
                        .border(width = 8.dp, color = Color.Cyan)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                        Image(painter = painterResource(R.drawable.i20),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(100.dp,30.dp))
                        Text(text = " Has obtenido $contador puntos, epicardo ",
                            fontSize = 25.sp,
                            textAlign = TextAlign.Center,
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(25.dp,20.dp,25.dp,20.dp))
                    }
            }
    }
}}