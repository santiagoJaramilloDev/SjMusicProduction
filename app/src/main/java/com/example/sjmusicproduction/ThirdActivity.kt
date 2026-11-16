package com.example.sjmusicproduction

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.thirdMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGoToEnd: Button = findViewById(R.id.btnGoToEnd)
        val textViewName: TextView = findViewById(R.id.textViewName)
        val textViewEmail: TextView = findViewById(R.id.textViewEmail)
        val textViewCourse: TextView = findViewById(R.id.textViewCourse)

        val name = intent.getStringExtra("name") ?: ""
        val email = intent.getStringExtra("email") ?: ""
        val course = intent.getStringExtra("course") ?: ""

        textViewName.text = getString(R.string.label_name, name)
        textViewEmail.text = getString(R.string.label_email, email)
        textViewCourse.text = getString(R.string.label_course, course)

        btnGoToEnd.setOnClickListener {
            finishAffinity()
        }
    }
}