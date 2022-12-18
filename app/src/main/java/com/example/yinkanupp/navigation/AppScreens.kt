package com.example.yinkanupp.navigation

sealed class AppScreens(val ruta: String){
    object SplashScreen: AppScreens("splash_screen")
    object MenuInicial: AppScreens("menu_inicial")
    object Formulario: AppScreens("formulario")
    object ScaffordScreen: AppScreens("scafford_screen")
    object IniciarGymkana: AppScreens("iniciar_gymkana")
    object Login: AppScreens("login")
    object ElegirGymkana: AppScreens("elegir_gymkana")
    object Cuestionario: AppScreens("cuestionario")
    object CuestionarioAnime: AppScreens("cuestionario_anime")
    object CuestionarioVideojuegos: AppScreens("cuestionario_videojuegos")
    object Resultado: AppScreens("resultado")
    object ResultadoAnime: AppScreens("resultado_anime")
    object ResultadoVideojuegos: AppScreens("resultado_videojuegos")
}