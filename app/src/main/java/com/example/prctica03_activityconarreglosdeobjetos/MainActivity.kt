package com.example.prctica03_activityconarreglosdeobjetos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val arregloMotocicletas = arrayOfNulls<Motocicleta>(10)
    private var contador = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los elementos de la interfaz
        val editNumeroSerie = findViewById<EditText>(R.id.editNumeroSerie)
        val editMarca = findViewById<EditText>(R.id.editMarca)
        val editModelo = findViewById<EditText>(R.id.editModelo)
        val editCilindrada = findViewById<EditText>(R.id.editCilindrada)
        val textResultado = findViewById<TextView>(R.id.textResultado)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val btnBuscar = findViewById<Button>(R.id.btnBuscar)
        val btnLimpiar = findViewById<Button>(R.id.btnLimpiar)

        // Botón para agregar información al arreglo
        btnAgregar.setOnClickListener {
            if (contador < arregloMotocicletas.size) {
                val numeroSerie = editNumeroSerie.text.toString()
                val marca = editMarca.text.toString()
                val modelo = editModelo.text.toString()
                val cilindrada = editCilindrada.text.toString().toIntOrNull() ?: 0

                // Crear instancia de motocicleta y agregar al arreglo
                arregloMotocicletas[contador] = Motocicleta(numeroSerie, marca, modelo, cilindrada)
                contador++

                textResultado.text = "Motocicleta agregada exitosamente."
            } else {
                textResultado.text = "No se puede agregar más motocicletas. Arreglo lleno."
            }
        }

        // Botón para buscar una motocicleta por número de serie
        btnBuscar.setOnClickListener {
            val numeroSerie = editNumeroSerie.text.toString()
            val motocicletaEncontrada = arregloMotocicletas.find { it?.numeroSerie == numeroSerie }

            if (motocicletaEncontrada != null) {
                editMarca.setText(motocicletaEncontrada.marca)
                editModelo.setText(motocicletaEncontrada.modelo)
                editCilindrada.setText(motocicletaEncontrada.cilindrada.toString())
                textResultado.text = "Motocicleta encontrada."
            } else {
                textResultado.text = "Motocicleta no encontrada."
            }
        }

        // Botón para limpiar las cajas de texto
        btnLimpiar.setOnClickListener {
            editNumeroSerie.text.clear()
            editMarca.text.clear()
            editModelo.text.clear()
            editCilindrada.text.clear()
            textResultado.text = ""
        }
    }
}