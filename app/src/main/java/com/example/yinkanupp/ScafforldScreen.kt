package com.example.yinkanupp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun ScafforldScreen(navController:NavHostController){
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
Column() {
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar {
                IconButton(onClick= {
                    scope.launch { // Abrir drawer
                        scaffoldState.drawerState.open()
                    }
                }){
                    Icon(Icons.Filled.Menu,
                        contentDescription = "Abrir menu")
                }
                Text(text = "Esta es segunda parte")
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = null
                )
                Icon(
                    Icons.Default.Share,
                    contentDescription = null
                )
        }},
        floatingActionButton = {
            FloatingActionButton(onClick = { /* ... */ }) {
                /* FAB content */
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Crear")
            }
        },
        // Defaults to false
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar { /* Bottom app bar content */ }
        },
        drawerContent = {
             // Cerrar drawer
                scope.launch { scaffoldState.drawerState.close() }

            Text("My count", modifier = Modifier.padding(0.dp))
            Divider()
            // Drawer items
        DrawerContent()
        }) {}

}
}

@Composable
fun DrawerContent() {
    val sections = listOf(
        "Bandeja de entrada",
        "Enviados", "Archivados",
        "Favoritos",
        "Papelera"
    )
    Column(Modifier.padding(vertical = 8.dp)) {
        sections.forEach { section ->
            TextButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {

                    val textColor = MaterialTheme.colors.onSurface
                    Text(
                        text = section,
                        style = MaterialTheme.typography.body2.copy(color = textColor)
                    )
                }
            }
        }
    }
}