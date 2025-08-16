package com.example.quizdog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class QuizActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var optionButtons: List<Button>
    private var currentQuestionIndex = 0
    private var score = 0
    private lateinit var questions: List<Question>

    private val delayMillis: Long = 1000 // Delay de 1 segundo antes de carregar a próxima

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        imageView = findViewById(R.id.dogImage)
        optionButtons = listOf(
            findViewById(R.id.option1),
            findViewById(R.id.option2),
            findViewById(R.id.option3),
            findViewById(R.id.option4)
        )

        questions = DogRepository.getQuestions()
        showQuestion()

        optionButtons.forEachIndexed { index, button ->
            button.setOnClickListener {
                handleAnswer(index, button)
            }
        }
    }

    private fun showQuestion() {
        if (currentQuestionIndex >= questions.size) {
            Toast.makeText(this, "Quiz acabou! Pontuação: $score", Toast.LENGTH_LONG).show()
            currentQuestionIndex = 0
            score = 0
        }

        val question = questions[currentQuestionIndex]

        Glide.with(this)
            .load(question.imageUrl)
            .placeholder(ColorDrawable(Color.LTGRAY)) // cinza enquanto carrega
            .error(ColorDrawable(Color.LTGRAY))       // cinza se falhar
            .into(imageView)

        optionButtons.forEachIndexed { index, button ->
            button.text = question.options[index]
            button.setBackgroundColor(Color.LTGRAY)
            button.isEnabled = true
        }
    }

    private fun handleAnswer(selectedIndex: Int, button: Button) {
        val correctIndex = questions[currentQuestionIndex].correctAnswerIndex
        optionButtons.forEach { it.isEnabled = false }

        if (selectedIndex == correctIndex) {
            score++
            button.setBackgroundColor(Color.GREEN)
        } else {
            button.setBackgroundColor(Color.RED)
            optionButtons[correctIndex].setBackgroundColor(Color.GREEN)
        }

        // Incrementa o índice antes do delay para carregar a próxima imagem corretamente
        currentQuestionIndex++

        Handler(Looper.getMainLooper()).postDelayed({
            showQuestion()
        }, delayMillis)
    }


}
