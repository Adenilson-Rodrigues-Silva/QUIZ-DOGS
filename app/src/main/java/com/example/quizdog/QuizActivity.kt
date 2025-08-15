package com.example.quizdog


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide



class QuizActivity : AppCompatActivity() {

    private lateinit var dogImage: ImageView
    private lateinit var option1: Button
    private lateinit var option2: Button
    private lateinit var option3: Button
    private lateinit var option4: Button
    private lateinit var questionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        dogImage = findViewById(R.id.dogImage)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        questionText = findViewById(R.id.textViewQuiz)


        // Teste inicial: carregar imagem fixa
        Glide.with(this)
            .load("https://images.dog.ceo/breeds/hound-afghan/n02088094_1003.jpg")
            .into(dogImage)

        // Aqui você pode configurar os botões com texto e lógica de clique
    }
}
