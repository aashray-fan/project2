package com.aashray.kotlintesting

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : Activity() {

    // The input field where the user enters their email.
    private lateinit var emailText: EditText

    // The validator for the email input field.
    private var emailValidator = EmailValidator()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Shortcuts to input fields.
        emailText = findViewById(R.id.emailInput)

        // Setup email field validator.
        emailText.addTextChangedListener(emailValidator)
    }
}