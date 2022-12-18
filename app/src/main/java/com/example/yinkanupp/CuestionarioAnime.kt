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
fun CuestionarioAnime(navController: NavHostController) {
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
            TiposScreenAnime(listaTiposAnime = ListaTiposAnime.tipos, navController)
        }
    }
}
var contadorAnime = 0;
data class PreguntaAnime(
    val tituloAnime: String,
    val respuestasAnime: List<String>
)
object ListaTiposAnime{

    val tipos = listOf(
        Pregunta( "¿En qué idioma están escritas las instrucciones de la Death Note?", respuestas = listOf("Japonés","Inglés","Francés")),
        Pregunta( "¿Qué parte del cuerpo le falta a Guts, protagonista de Berserk?", respuestas = listOf("Pierna","Oreja","Brazo")),
        Pregunta("¿Qué otro poder hay en One Piece aparte de las Frutas del Diablo?", respuestas =  listOf("Haki","Chakra","Chi")),
        Pregunta("¿Cuántas bolas de dragón hay que reunir para invocar a Shenron?", respuestas = listOf("5","9","7")),
        Pregunta( "En Naruto ¿qué animal es la forma definitiva de Choji?", respuestas = listOf("Oso","Mariposa","Serpiente")),
        Pregunta( "¿De qué color tiene el pelo Deku, el prota de My Hero Academia?", respuestas = listOf("Rojo","Azul","Verde")),
        Pregunta("¿Cuál es el apellido de Conan, el niño detective?", respuestas =  listOf("Edogawa","Tanaka","Kobayashi")),
        Pregunta("¿Quién es Lupin III?", respuestas = listOf("Asesino","Ladrón","Policía")),
        Pregunta( "En Inazuma Eleven ¿cuál es la primera técnica de Axel Blaze?", respuestas = listOf("Mano celestial","Tornado de fuego","El muro")),
        Pregunta( "¿Contra qué luchan los protagonistas de Evangelion?", respuestas = listOf("Kaiju","Demonios","Ángeles")))
}
@Composable
fun TiposScreenAnime (listaTiposAnime: List<Pregunta>, navController: NavHostController) {

    listaTiposAnime.forEach { Pregunta ->
        CardlistasAnime(
            titulo = Pregunta.titulo,
            respuestas = Pregunta.respuestas
        )
    }
    ColocarBotones(text = "Comprobar", separacion = 60, navController, ruta = AppScreens.ResultadoAnime.ruta )

}

@Composable
fun CardlistasAnime(titulo: String,respuestas: List<String>) {

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
            if (selectedOption.value.equals("Inglés")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Brazo")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Haki")){

                contadorAnime++

            }
            if (selectedOption.value.equals("7")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Mariposa")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Verde")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Edogawa")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Ladrón")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Tornado de fuego")){

                contadorAnime++

            }
            if (selectedOption.value.equals("Ángeles")){

                contadorAnime++

            }
        }
    }

}