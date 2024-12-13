package com.example.salonhabana


import android.app.DatePickerDialog
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.icu.util.Calendar
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class SegundaVentana : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var btnDatePicker: Button
    private var calendar = Calendar.getInstance()
    lateinit var spinnerReserva : Spinner
    lateinit var noticiaSeleccionada: String
    var congreso: Boolean = false
    lateinit var Cocina : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.tipo_reserva)
        btnDatePicker = findViewById(R.id.buttonFecha)
        spinnerReserva = findViewById<Spinner>(R.id.spinnerTipoReserva)
        Cocina = findViewById<Spinner>(R.id.spinnerCocina)
        val sumar = findViewById<Button>(R.id.buttonsumar)
        val restar = findViewById<Button>(R.id.buttonRestar)
        val personas = findViewById<TextView>(R.id.textViewPersonas)
        val reservar = findViewById<Button>(R.id.buttonReserva)
        var cantidad = 0
        var cantidadW = cantidad.toString()
        android.widget.ArrayAdapter.createFromResource(
            this,
            R.array.tipo_reserva,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerReserva.adapter = adapter
        }
        android.widget.ArrayAdapter.createFromResource(
            this,
            R.array.tipo_cocina,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            Cocina.adapter = adapter
        }


        spinnerReserva.onItemSelectedListener = this
        Cocina.onItemSelectedListener = this

        personas.setText(cantidadW)

        btnDatePicker.setOnClickListener {
            // Show the DatePicker dialog
            openDialog()
        }
        sumar.setOnClickListener {
            cantidadW = (cantidad + 1).toString()
            personas.setText(cantidadW)
            cantidad = cantidadW.toInt()
        }
        restar.setOnClickListener {
            cantidadW = (cantidad - 1).toString()
            personas.setText(cantidadW)
            cantidad = cantidadW.toInt()
        }

        reservar.setOnClickListener {
            if (spinnerReserva.selectedItem.toString() == "Congreso"){
                val intent = Intent(this,TerceraVentana::class.java)
                startActivity(intent)
            }else{
                val intent = Intent(this,VentanaFin::class.java)
                startActivity(intent)
            }
        }

    }


    fun openDialog(){

        val datePickerDialog = DatePickerDialog(
            this, {DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
                // Create a new Calendar instance to hold the selected date
                val selectedDate = Calendar.getInstance()
                // Set the selected date using the values received from the DatePicker dialog
                selectedDate.set(year, monthOfYear, dayOfMonth)
                // Create a SimpleDateFormat to format the date as "dd/MM/yyyy"
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                // Format the selected date into a string
                val formattedDate = dateFormat.format(selectedDate.time)
                // Update the TextView to display the selected date with the "Selected Date: " prefix
                val tvSelectedDate = "Fecha seleccionada: $formattedDate"
                Toast.makeText(this, tvSelectedDate, Toast.LENGTH_SHORT).show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        // Show the DatePicker dialog
        datePickerDialog.show()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}