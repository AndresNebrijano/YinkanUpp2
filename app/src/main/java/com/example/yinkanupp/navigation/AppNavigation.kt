package com.example.yinkanupp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.yinkanupp.*

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController, startDestination = AppScreens.SplashScreen.ruta
    ){
        composable(AppScreens.SplashScreen.ruta){ SplashScreen(navigationController)}
        composable(AppScreens.MenuInicial.ruta){ MostrarMenuInicial(navigationController)}
        composable(AppScreens.Formulario.ruta){ Formulario(navigationController)}
        composable(AppScreens.ScaffordScreen.ruta){ ScafforldScreen(navigationController)}
        composable(AppScreens.IniciarGymkana.ruta){ IniciarGymkana(navigationController)}
        composable(AppScreens.Login.ruta){ Login(navigationController)}
    }
}