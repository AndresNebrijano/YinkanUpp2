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
import androidx.compose.ui.Alignment
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
        Pregunta( "En Star Trek ??a qu?? raza pertenece Spock?", respuestas = listOf("Vulcano","Borg","Klingon")),
        Pregunta( "??Cu??ntos anillos recibieron los se??ores enanos?", respuestas = listOf("9","3","7")),
        Pregunta("??Cu??l es el verdadero nombre de Indiana Jones?", respuestas =  listOf("James","John","Henry")),
        Pregunta("??Qu?? personaje tiene la Gema del Tiempo en las peliculas de Marvel?", respuestas = listOf("Dr Strange","Loki","Visi??n")),
        Pregunta( "??C??mo se llama el padre de Bella en la pel??cula de Disney?", respuestas = listOf("Fran??ois","Maurice","Renard")),
        Pregunta( "??De qu?? est?? hecho el n??cleo de la varita de Harry Potter?", respuestas = listOf("Fibra de coraz??n de drag??n","Pelo de cola de unicornio","Pluma de f??nix")),
        Pregunta("Aparte del Maestro de las Llaves, ??a qui??n m??s necesitamos para invocar a Gozer, el Destructor?", respuestas =  listOf("Guardiana de la Puerta","Maestra de la Cerradura","Guardiana del Portal")),
        Pregunta("Termina la frase: 'El tiempo no es importante,...'", respuestas = listOf("...solo saber donde quieres ir","...solo la vida es importante","...sal de fiesta y olvida tus problemas")),
        Pregunta( "??En qu?? componente de los seres vivos se mide la Fuerza de un Jedi?", respuestas = listOf("Globolitos","Forcenses","Midiclorianos")),
        Pregunta( "Valar Morghulis...", respuestas = listOf("Valar Oloris","Valar Dohaeris","Valar Dothrakis")))
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
            if (selectedOption.value.equals("Vulcano")){

            contador++

        }
            if (selectedOption.value.equals("7")){

                contador++

            }
            if (selectedOption.value.equals("Henry")){

                contador++

            }
            if (selectedOption.value.equals("Dr Strange")){

                contador++

            }
            if (selectedOption.value.equals("Maurice")){

                contador++

            }
            if (selectedOption.value.equals("Pluma de f??nix")){

                contador++

            }
            if (selectedOption.value.equals("Guardiana de la Puerta")){

                contador++

            }
            if (selectedOption.value.equals("...solo la vida es importante")){

                contador++

            }
            if (selectedOption.value.equals("Midiclorianos")){

                contador++

            }
            if (selectedOption.value.equals("Valar Dohaeris")){

                contador++

            }
        }
    }

}