package com.example.yinkanupp

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.yinkanupp.navigation.AppScreens

@Composable
fun CuestionarioVideojuegos(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
            .verticalScroll(rememberScrollState())
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)

            )
            TiposScreenVideojuegos(listaTiposVideojuegos = ListaTiposVideojuegos.tipos, navController)
        }
    }
}
var contadorVideojuegos = 0;
data class PreguntaVideojuegos(
    val tituloVideojuegos: String,
    val respuestasVideojuegos: List<String>
)
object ListaTiposVideojuegos{

    val tipos = listOf(
        Pregunta( "¿Cuál de estos poderes fue introducido en Super Mario Galaxy?", respuestas = listOf("Flor de fuego","Ardilla voladora","Abeja")),
        Pregunta( "En Zelda: Majora´s Mask ¿en qué convierte Skull Kid a Link?", respuestas = listOf("Zora","Goron","Deku")),
        Pregunta("¿Cuántos Pokémon hay en la primera generación?", respuestas =  listOf("100","151","150")),
        Pregunta("¿Qué animal es Crash?", respuestas = listOf("Koala","Bandicoot","Canguro")),
        Pregunta( "¿Cómo se llama el hermano de Dante en la saga Devil May Cry?", respuestas = listOf("Vergil","Alphonse","Liquid")),
        Pregunta( "¿Cómo se obtienen los Yokai en Yokai Watch?", respuestas = listOf("Tienda de Yokai","Máquina de Gashapon","Talismanes de invocación")),
        Pregunta("¿Qué personaje se introdujo en la expansión de Diablo III?", respuestas =  listOf("Amazona","Druida","Cruzado")),
        Pregunta("En Final Fantasy IX ¿cuántos Vals Negros se enfrentan a los héroes?", respuestas = listOf("3","2","5")),
        Pregunta( "¿Qué le pasa a Sir Arthur (Ghost and Goblins) cuando le golpean una vez?", respuestas = listOf("Pierde el escudo","Se queda en calzoncillos","Pierde un punto de vida")),
        Pregunta( "¿Qué famoso juego hizo que hubiera escasez de monedas en Japón?", respuestas = listOf("Tetris","Pac-Man","Space Invaders")))
}
@Composable
fun TiposScreenVideojuegos (listaTiposVideojuegos: List<Pregunta>, navController: NavHostController) {

    listaTiposVideojuegos.forEach { Pregunta ->
        CardlistasVideojuegos(
            titulo = Pregunta.titulo,
            respuestas = Pregunta.respuestas
        )
    }
    ColocarBotones(text = "Comprobar", separacion = 60, navController, ruta = AppScreens.ResultadoVideojuegos.ruta )

}

@Composable
fun CardlistasVideojuegos(titulo: String,respuestas: List<String>) {

    val selectedOption = rememberSaveable { mutableStateOf(" ") }

    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier
            .border(BorderStroke(3.dp, color = Color.Cyan))
            .background(color = Color.Black.copy(alpha = 0.8f))) {
            Text(
                text = titulo,
                fontSize = 25.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(30.dp,15.dp)
            )
            //Text(text = "Selected value: ${selectedOption.value.ifEmpty { "NONE" }}")
            respuestas.forEach { item->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = (selectedOption.value == item),
                            onClick = { selectedOption.value = item },
                        )
                        .padding(horizontal = 16.dp)
                ){

                    IconToggleButton(
                        checked = selectedOption.value==item,
                        onCheckedChange = { selectedOption.value = item},

                        ) {
                        Icon(
                            painter = painterResource(
                                if (selectedOption.value==item) {
                                    R.drawable.ic_circle_checked
                                } else {
                                    R.drawable.ic_circle_outline
                                },
                            ),
                            contentDescription = null,
                            tint = Color(0xFFA715C0)

                        )
                    }
                    Text(
                        text = item,
                        style = MaterialTheme.typography.body1.merge(),
                        color= Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp),
                        fontSize = 20.sp
                    )
                }
            }
            if (selectedOption.value.equals("Abeja")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Deku")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("151")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Bandicoot")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Vergil")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Máquina de Gashapon")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Cruzado")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("3")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Se queda en calzoncillos")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Space Invaders")){

                contadorVideojuegos++

            }
        }
    }

}