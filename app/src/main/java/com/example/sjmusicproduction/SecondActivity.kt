package com.example.sjmusicproduction

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btnGoToThird: Button = findViewById(R.id.btnGoToThird)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val textViewSelection: TextView = findViewById(R.id.textViewSelection)
        val courses = arrayOf("Curso de mezcla", "Curso de masterización", "Curso de producción")
        var selectedCourse = ""

        textViewSelection.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Selecciona un curso")

            builder.setSingleChoiceItems(courses, -1) { dialog, which ->
                selectedCourse = courses[which]
            }

            builder.setPositiveButton("Aceptar") { _, _ ->
                if (selectedCourse.isNotEmpty()) {
                    textViewSelection.text = selectedCourse
                }
            }
            builder.setNegativeButton("Cancelar", null)

            builder.create().show()
        }

        btnGoToThird.setOnClickListener {
            // Obtener los valores del formulario
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()

            // Navegar a la tercera pantalla y pasar los datos
            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("email", email)
            intent.putExtra("course", selectedCourse)
            startActivity(intent)
        }
    }
}