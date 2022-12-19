package com.example.yinkanupp

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.yinkanupp.navigation.AppScreens

@Composable
fun ResultadoAnime (navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
            .verticalScroll(rememberScrollState())
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()

            )

            if(contadorAnime <5 ){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.yamcha),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contadorAnime /20 puntos. Eres como Yamcha, un 0 muerto a la izquierda",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contadorAnime >=5 && contadorAnime <10){
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.deku),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contadorAnime /20 puntos. Ni Deku de crío era tan inútil",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }else if (contadorAnime >=10 && contadorAnime <15) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(50.dp, 50.dp)
                        .border(width = 8.dp, color = Color.Cyan)
                        .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(
                        painter = painterResource(R.drawable.gurren),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp, 30.dp))
                    Text(
                        text = " Has obtenido $contadorAnime /20 puntos. Un poco más y taladras el cielo",
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp, 20.dp, 25.dp, 20.dp)
                    )
                }
            }  else{
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(50.dp,50.dp)
                    .border(width = 8.dp, color = Color.Cyan)
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))) {
                    Image(painter = painterResource(R.drawable.kira),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(100.dp,30.dp))
                    Text(text = " Has obtenido $contadorAnime /20 puntos. Eres más listo que el mismísimo Kira",
                        fontSize = 25.sp,
                        textAlign = TextAlign.Center,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(25.dp,20.dp,25.dp,20.dp))
                }
            }
            ColocarBotones(text = "Volver al menú", separacion = 60, navController, ruta = AppScreens.ElegirGymkana.ruta )
        }
    }
}