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
        Pregunta( "Videojuegos", respuestas = listOf("¿Más Proyectos?","¡Zomoz dezarrolladorez!","¡Somos desarrolladores!")),
        Pregunta( "¿Cual de las siguientes opciones no es un lenguaje?", respuestas = listOf("Cow","Chicken","Ouch")),
        Pregunta("Si tenemos 2000$, y cada Pokeball cuesta 200$. ¿Cuantas Pokeball podremos comprar?", respuestas =  listOf("10","11","¿Que es una Pokeball?")),
        Pregunta("¿Como se llama el famoso heroe que se enfrentó a Malenia y ayudo a miles de jugadores?", respuestas = listOf("I Am Her","I Am Solo Here","Let Me Solo Her")),
        Pregunta( "¿Cual es la herramienta favorita de Tetsuya Nomura?", respuestas = listOf("Cremalleras","Personajes Furros","LLaves Espada")),
        Pregunta( "¿Que famoso alienigena tiene un comic/manga en la epoca de Nobunaga?", respuestas = listOf("E.T.","Predator","Stitch")),
        Pregunta("¿Cuanta inflación ha sufrido 'El Diablo' en el último mes?", respuestas =  listOf("100%","50%","30%")),
        Pregunta("Termina la frase: 'El tiempo no es importante,.....'", respuestas = listOf("...solo saber donde quieres ir","...solo la vida es importante","...sal de fiesta y olvida tus problemas")),
        Pregunta( "¿Cuantas veces ha muerto Kenny en 'South Park' en total?", respuestas = listOf("103","92","79")),
        Pregunta( "¿Que animal fue el más repetido en la visita del 3DOM a Cáceres?", respuestas = listOf("Zanganos","Burros","Ovejas")))
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
            if (selectedOption.value.equals("¡Somos desarrolladores!")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Ouch")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("11")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Let Me Solo Her")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Cremalleras")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Stitch")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("30%")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("...solo la vida es importante")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("103")){

                contadorVideojuegos++

            }
            if (selectedOption.value.equals("Ovejas")){

                contadorVideojuegos++

            }
        }
    }

}