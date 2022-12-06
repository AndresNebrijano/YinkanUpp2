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
            TiposScreen(listaTipos = ListaTipos.tipos)
        }
    }
}
data class Pregunta(
    val titulo: String,
    val respuestas: List<String>
)
object ListaTipos{
    val tipos = listOf(
        Pregunta( "Pregunta 1", respuestas = listOf("Zorra","Puta","HDP")),
    Pregunta( "Pregunta 2", respuestas = listOf("Zorra","Puta","HDP")),
    Pregunta("Pregunta 3", respuestas =  listOf("Zorra","Puta","HDP")),
    Pregunta("Pregunta 4", respuestas = listOf("Zorra","Puta","HDP")))
}
@Composable
fun TiposScreen (listaTipos: List<Pregunta>) {

    listaTipos.forEach { Pregunta ->
        Cardlistas(
            titulo = Pregunta.titulo,
            respuestas = Pregunta.respuestas
        )
    }
}

@Composable
fun Cardlistas(titulo: String,respuestas: List<String>) {


    val selectedOption = rememberSaveable { mutableStateOf(respuestas[1]) }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()

    ) {
        Column(modifier = Modifier
            .border(BorderStroke(3.dp, color = Color.Magenta))
            .background(color = Color.Black.copy(alpha = 0.4f))) {
            Text(text = titulo)

            respuestas.forEach { item->
                Row(
                    modifier = Modifier
                        .selectable(
                        selected = (selectedOption.value == item),
                        onClick = {selectedOption.value = item},
                        )
                        .padding(horizontal = 16.dp)
                ){

                    IconToggleButton(
                    checked = selectedOption.value==item,
                    onCheckedChange = { selectedOption.value = item}

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
        }
    }
}