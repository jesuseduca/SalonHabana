package com.example.salonhabana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val botonHabana = findViewById<Button>(R.id.buttonSiguiente)

        botonHabana.setOnClickListener {
            val intent = Intent(this,SegundaVentana::class.java)
            startActivity(intent)
        }

    }
}