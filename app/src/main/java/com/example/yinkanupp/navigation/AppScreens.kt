package com.example.yinkanupp.navigation

sealed class AppScreens(val ruta: String){
    object SplashScreen: AppScreens("splash_screen")
    object MenuInicial: AppScreens("menu_inicial")
    object Formulario: AppScreens("formulario")
    object ScaffordScreen: AppScreens("scafford_screen")
}