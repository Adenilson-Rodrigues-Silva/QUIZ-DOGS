    package com.example.quizdog

// Question.kt
data class Question(
    val imageUrl: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
