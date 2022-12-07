package com.example.yinkanupp

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.yinkanupp.navigation.AppScreens
import com.example.yinkanupp.ui.theme.YinkanUppTheme

@Composable
fun Cuestionario(navController: NavHostController) {
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
                    .background(color = Color.Black)

            )
            TiposScreen(listaTipos = ListaTipos.tipos, navController)
        }
    }
}
var contador = 0;
data class Pregunta(
    val titulo: String,
    val respuestas: List<String>
)
object ListaTipos{
    val tipos = listOf(
        Pregunta( "¿Cual es el grito de guerra de DAM?", respuestas = listOf("¿Más Proyectos?","¡Zomoz dezarrolladorez!","¡Somos desarrolladores!")),
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
fun TiposScreen (listaTipos: List<Pregunta>, navController: NavHostController) {

    listaTipos.forEach { Pregunta ->
        Cardlistas(
            titulo = Pregunta.titulo,
            respuestas = Pregunta.respuestas
        )
    }
    ColocarBotones(text = "Comprobar", separacion = 60, navController, ruta = AppScreens.Resultado.ruta )

}

@Composable
fun Cardlistas(titulo: String,respuestas: List<String>) {

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
                        color=Color.White,
                        modifier = Modifier
                            .padding(start = 16.dp),
                        fontSize = 20.sp
                    )
                }
            }
            if (selectedOption.value.equals("¡Somos desarrolladores!")){

            contador++

        }
            if (selectedOption.value.equals("Ouch")){

                contador++

            }
            if (selectedOption.value.equals("11")){

                contador++

            }
            if (selectedOption.value.equals("Let Me Solo Her")){

                contador++

            }
            if (selectedOption.value.equals("Cremalleras")){

                contador++

            }
            if (selectedOption.value.equals("Stitch")){

                contador++

            }
            if (selectedOption.value.equals("30%")){

                contador++

            }
            if (selectedOption.value.equals("...solo la vida es importante")){

                contador++

            }
            if (selectedOption.value.equals("103")){

                contador++

            }
            if (selectedOption.value.equals("Ovejas")){

                contador++

            }
        }
    }

}