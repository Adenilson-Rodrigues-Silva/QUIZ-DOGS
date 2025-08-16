package com.example.quizdog



import retrofit2.http.GET

data class DogResponse(
    val message: String, // URL da imagem
    val status: String
)

interface DogApi {
    @GET("breeds/image/random") // endpoint da API
    suspend fun getRandomDogImage(): DogResponse
}
