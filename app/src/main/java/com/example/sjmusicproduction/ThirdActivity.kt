package com.example.sjmusicproduction

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val btnGoToEnd: Button = findViewById(R.id.btnGoToEnd)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val textViewCourse: TextView = findViewById(R.id.textViewCourse)

        // Obtener los datos enviados desde la segunda pantalla
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val course = intent.getStringExtra("course")

        // Mostrar los datos
        textViewName.text = "Nombre: $name"
        textViewEmail.text = "Correo: $email"
        textViewCourse.text = "Curso seleccionado: $course"

        btnGoToEnd.setOnClickListener {
            finishAffinity()
        }
    }
}