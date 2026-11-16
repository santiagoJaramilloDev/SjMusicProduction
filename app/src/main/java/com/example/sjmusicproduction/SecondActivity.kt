package com.example.sjmusicproduction

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.secondMain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGoToThird: Button = findViewById(R.id.btnGoToThird)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val textViewSelection: TextView = findViewById(R.id.textViewSelection)

        val courses = arrayOf(
            getString(R.string.course_mixing),
            getString(R.string.course_mastering),
            getString(R.string.course_production)
        )
        var selectedCourse = ""

        textViewSelection.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.dialog_select_course_title))

            val checkedItem = courses.indexOf(selectedCourse)

            builder.setSingleChoiceItems(courses, checkedItem) { _, which ->
                selectedCourse = courses[which]
            }

            builder.setPositiveButton(getString(R.string.btn_accept)) { _, _ ->
                if (selectedCourse.isNotEmpty()) {
                    textViewSelection.text = selectedCourse
                }
            }
            builder.setNegativeButton(getString(R.string.btn_cancel), null)

            builder.create().show()
        }

        btnGoToThird.setOnClickListener {
            val name = editTextName.text.toString().trim()
            val email = editTextEmail.text.toString().trim()

            if (name.isEmpty()) {
                editTextName.error = getString(R.string.error_fill_fields)
                Toast.makeText(this, R.string.error_fill_fields, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editTextEmail.error = getString(R.string.error_invalid_email)
                Toast.makeText(this, R.string.error_invalid_email, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (selectedCourse.isEmpty()) {
                Toast.makeText(this, R.string.error_fill_fields, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, ThirdActivity::class.java).apply {
                putExtra("name", name)
                putExtra("email", email)
                putExtra("course", selectedCourse)
            }
            startActivity(intent)
        }
    }
}