package com.example.quizdog

// DogRepository.kt


import com.example.quizdog.api.DogApi
import com.example.quizdog.model.Question

object DogRepository {

    private val api = RetrofitInstance.api // instancia do Retrofit

    suspend fun getQuestion(): Question {
        val response = api.getRandomDogImage()
        return Question(
            imageUrl = response.message,
            options = listOf("Beagle", "Afghan Hound", "Labrador", "Bulldog"), // você pode randomizar
            correctAnswerIndex = 0 // ajuste conforme a opção correta
        )
    }
}
