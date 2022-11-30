package com.example.yinkanupp

import android.widget.RadioGroup
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.semantics.Role.Companion.RadioButton
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

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

        Column() {
            val bannerhead = painterResource(R.drawable.logo)
            Image(
                painter = bannerhead,
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black)

            )
            onCreate()
        }
    }
}

@Composable
 fun onCreate() {
     val tipos = listOf("Primera", "Segundo", "Tercero")
    val selectedOption= rememberSaveable { mutableStateOf(tipos[1] )}

    Column {
        Text(text = "Selected value: ${selectedOption.value.ifEmpty { "NONE" }} ",color=Color.White,  )
        tipos.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (selectedOption.value == text),
                        onClick = { selectedOption.value = text }
                    )
                    .padding(horizontal = 16.dp)
            ) {
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
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    color=Color.White,
                    modifier = Modifier
                        .padding(start = 16.dp)
                )
            }
        }
    }
 }

/*@Composable
fun siguiente (View v){
    //if por si no se marca ninguna opcion
    if(rdOpc1.isChecked() == false && rdOpc2.isChecked() == false && rdOpc3.isChecked()==false){
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


