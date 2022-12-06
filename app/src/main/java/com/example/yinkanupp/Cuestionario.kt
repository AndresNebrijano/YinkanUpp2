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
    Card() {
        Column(modifier = Modifier
            .padding(60.dp, 100.dp)
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


//val tipos = listOf("opcion1","opcion2","opcion3","opcion4")
//val questions:ArrayList<Question> = getQuestions()
//val selectedOption= rememberSaveable { mutableStateOf(tipos[0])}

/*Column (modifier = Modifier
    .padding(60.dp, 100.dp)
    .border(BorderStroke(3.dp, color = Color.Magenta))
    .background(color = Color.Black.copy(alpha = 0.4f))){


    //Text(text="¿Cuando nació Santiago Manuel?", color = Color.White, fontSize = 30.sp, modifier = Modifier.padding(20.dp,0.dp))
    //Text(text = "Selected value: ${selectedOption.value.ifEmpty { "NONE" }} ",color=Color.White, fontSize = 25.sp)


        Text(text =titulo)
       Row(
           Modifier
               .fillMaxWidth()
               .selectable(
                   selected = (selectedOption.value == text),
                   onClick = { selectedOption.value = text }
               )
               .padding(horizontal = 16.dp)
        ) {
           Text(
               text = text ,
               style = MaterialTheme.typography.body1.merge(),
               color=Color.White,
               modifier = Modifier
                   .padding(start = 16.dp),
               fontSize = 20.sp
           )
           for(i in respuestas.indices){
            IconToggleButton(
                /*selected = (selectedOption.value == text),
                onClick = { selectedOption.value=text },*/
                checked = selectedOption.value == text,
                onCheckedChange = { selectedOption.value=text },

            ){
                Icon(
                    painter = painterResource(
                        if (selectedOption.value == text) {
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
                   text = ,
                   style = MaterialTheme.typography.body1.merge(),
                   color=Color.White,
                   modifier = Modifier
                       .padding(start = 16.dp),
                   fontSize = 20.sp)
           }
        }
    }*/
    /*Button(onClick = changeQuestion())
        //your onclick code here
    {
        Text(text = "Enviar")
    }*/

/*@Composable
fun siguiente (){
//if por si no se marca ninguna opcion
if(selectedOption.value.isChecked() == false && rdOpc2.isChecked() == false && rdOpc3.isChecked()==false){
    Toast.makeText(this, "Elija una opción", Toast.LENGTH_SHORT).show();
}else if(Npregunta == 1){
    //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
    if(rdOpc2.isChecked()){
        nota = nota + 2;
    }
    //Se le suma 1 al contador de la pregunta
    // Npregunta = Npregunta + 1;
    //Se setean los textos para la siguiente pregunta
    txtNpregunta.setText("Pregunta 2");
    txtPregunta.setText("Esta es la pregunta 2, su respuesta correcta es la opcion 1");
    rdOpc1.setText("Opcion 1 p2");
    rdOpc2.setText("Opcion 2 p2");
    rdOpc3.setText("Opcion 3 p2");
    //Se limpian los Radio buttons para la siguiente pregunta
    rdOpc1.setChecked(false);
    rdOpc2.setChecked(false);
    rdOpc3.setChecked(false);
}else if(Npregunta == 2) {
    //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
    if (rdOpc1.isChecked()) {
        nota = nota + 2;
    }
    //Se le suma 1 al contador de la pregunta
    Npregunta = Npregunta + 1;
    //Se setean los textos para la siguiente pregunta
    txtNpregunta.setText("Pregunta 3");
    txtPregunta.setText("Esta es la pregunta 3, su respuesta correcta es la opcion 3");
    rdOpc1.setText("Opcion 1 p3");
    rdOpc2.setText("Opcion 2 p3");
    rdOpc3.setText("Opcion 3 p3");
                //Se limpian los Radio buttons para la siguiente pregunta
    rdOpc1.setChecked(false);
    rdOpc2.setChecked(false);
    rdOpc3.setChecked(false);
}else if(Npregunta == 3) {
    //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
    if (rdOpc3.isChecked()) {
        nota = nota + 2;
    }
    //Se le suma 1 al contador de la pregunta
    Npregunta = Npregunta + 1;
    //Se setean los textos para la siguiente pregunta
    txtNpregunta.setText("Pregunta 4");
    txtPregunta.setText("Esta es la pregunta 4, su respuesta correcta es la opcion 1");
    rdOpc1.setText("Opcion 1 p4");
    rdOpc2.setText("Opcion 2 p4");
    rdOpc3.setText("Opcion 3 p4");
    //Se limpian los Radio buttons para la siguiente pregunta
    rdOpc1.setChecked(false);
    rdOpc2.setChecked(false);
    rdOpc3.setChecked(false);
}else if(Npregunta == 4) {
    //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
    if (rdOpc1.isChecked()) {
        nota = nota + 2;
    }
    //Se le suma 1 al contador de la pregunta
    Npregunta = Npregunta + 1;
    //Se setean los textos para la siguiente pregunta
    txtNpregunta.setText("Pregunta 5");
    txtPregunta.setText("Esta es la pregunta 5, su respuesta correcta es la opcion 2");
    rdOpc1.setText("Opcion 1 p5");
    rdOpc2.setText("Opcion 2 p5");
    rdOpc3.setText("Opcion 3 p5");
    //Se limpian los Radio buttons para la siguiente pregunta
    rdOpc1.setChecked(false);
    rdOpc2.setChecked(false);
    rdOpc3.setChecked(false);
}else if(Npregunta == 5) {
    //Se verifica la respuesta, si es correcta se agregan 2 puntos a la nota
    if (rdOpc2.isChecked()) {
        nota = nota + 2;
    }
    //Se setean los textos para el resultado de la nota
    txtNpregunta.setText("Nota obtenida: "+nota);
    //IF para verificar si se ha aprobado o reprobado
    if(nota >= 6){
        txtPregunta.setText("Estado: Aprobado");
    }else{
        txtPregunta.setText("Estado: Reprobado");
    }
    //Se ocultan las opciones que no se van a usar para ver la nota y resultado
    rdOpc1.setVisibility(View.GONE);
    rdOpc2.setVisibility(View.GONE);
    rdOpc3.setVisibility(View.GONE);
    btnSiguiente.setVisibility(View.GONE);
}
}

@Composable
fun Salir(View v){
finish();
}*/


/*data class Pregunta(
@DrawableRes val imageResource: Int,
val titulo: String,
val respuestas: List<String>
)

val preguntaList = listOf(
Pregunta(R.drawable.logo,"Pregunta 1", listOf("Zorra","Puta","HDP")),
Pregunta(R.drawable.logo,"Pregunta 2", listOf("Zorra","Puta","HDP")),
Pregunta(R.drawable.logo,"Pregunta 3", listOf("Zorra","Puta","HDP")),
Pregunta(R.drawable.logo,"Pregunta 4", listOf("Zorra","Puta","HDP"))
)
@Composable
fun PreguntaCard(pregunta:Pregunta,navController: NavHostController){
val image = painterResource(R.drawable.logo)
Surface(/*shape = RoundedCornerShape(8.dp), elevation = 8.dp, modifier = Modifier.padding(8.dp)*/) {
    Column(modifier = Modifier.padding(16.dp)) {
        val imageModifier = Modifier
            .fillMaxHeight(60f)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(8.dp))
        Image(painter = image,contentDescription = null, /*modifier = imageModifier,*/contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.fillMaxHeight(26f))
        Text(text = pregunta.titulo, style = typography.h6)
        for(respuesta in pregunta.respuestas){
            Text(text = respuesta, style = typography.body2)
        }
    }
}
}*/