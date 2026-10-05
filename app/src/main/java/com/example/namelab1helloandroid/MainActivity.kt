package com.example.namelab1helloandroid

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {
    var i = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener()
        val message = findViewById<TextView>(R.id.textViewMessage)
        val button = findViewById<Button>(R.id.buttonChangeText)
        button.setOnClickListener {
            message.text = "Button clicked!"
        }
    }
}