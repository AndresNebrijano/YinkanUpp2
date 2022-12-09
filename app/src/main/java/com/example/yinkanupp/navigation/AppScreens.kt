package com.example.yinkanupp.navigation

sealed class AppScreens(val ruta: String){
    object SplashScreen: AppScreens("splash_screen")
    object MenuInicial: AppScreens("menu_inicial")
    object Formulario: AppScreens("formulario")
    object ScaffordScreen: AppScreens("scafford_screen")
    object IniciarGymkana: AppScreens("iniciar_gymkana")
    object Login: AppScreens("login")
    object Cuestionario: AppScreens("cuestionario")
    object Resultado: AppScreens("resultado")
}