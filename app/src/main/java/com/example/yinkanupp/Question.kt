package com.example.yinkanupp

data class Question (
    val id: Int,
    val text: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: String
        )

fun getQuestions(): ArrayList<Question> {
    val questions = ArrayList<Question>()

    questions.add(
        Question(
            0,
            "¿En qué año se fundo el Equipo Torrija?",
            "1995",
            "2007",
            "2022",
            "Nunca existió, pregunte al Ministerio",
            "2022",
        )
    )
    return questions
}