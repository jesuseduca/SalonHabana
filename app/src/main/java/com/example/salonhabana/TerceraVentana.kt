package com.example.salonhabana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class TerceraVentana : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.parte_congreso)
        val congreso = findViewById<Button>(R.id.buttonCongreso)

        congreso.setOnClickListener {
            val intent = Intent(this,VentanaFin::class.java)
            startActivity(intent)
        }

    }
}