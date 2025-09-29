package com.appweek04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonColor = findViewById<Button>(R.id.buttonColor)

        buttonColor.setOnClickListener {
            startActivity(Intent(this, ColorActivity::class.java))
        }
    }
}