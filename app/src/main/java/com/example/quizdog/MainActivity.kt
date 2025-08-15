package com.example.quizdog

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pegando referência do botão
        val startButton: Button = findViewById(R.id.btnComecar)

        // Configurando clique
        startButton.setOnClickListener {
            // Intent para abrir a QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
        }
    }
}
