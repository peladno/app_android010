package com.example.ejercicio14modulo5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio14modulo5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var saldo = 0.0
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnVerSaldo.setOnClickListener {
            mostrarSaldo()
        }

        binding.btnIngresarDinero.setOnClickListener {
            ingresarDinero()
        }

        binding.btnSacarDinero.setOnClickListener {
            sacarDinero()
        }

        binding.btnSalir.setOnClickListener {
            finish()
        }
    }

    private fun mostrarSaldo() {
        Toast.makeText(this, "Saldo actual: $saldo", Toast.LENGTH_SHORT).show()
    }

    private fun ingresarDinero() {
        val input = binding.ingresaDineroInput
        val cantidad = input.text.toString().toDoubleOrNull()

        if (cantidad != null && cantidad > 0) {
            saldo += cantidad
            Toast.makeText(this, "Se ingresó $cantidad al saldo", Toast.LENGTH_SHORT).show()
            input.text?.clear()
        } else {
            if (input.text?.isBlank() == true) {
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun sacarDinero() {
        val input = binding.sacarDineroInput
        val cantidad = input.text.toString().toDoubleOrNull()

        if (cantidad != null && cantidad > 0) {
            if (cantidad <= saldo) {
                saldo -= cantidad
                Toast.makeText(this, "Se retiró $cantidad del saldo", Toast.LENGTH_SHORT).show()
                input.text?.clear()
            } else {
                Toast.makeText(this, "Saldo insuficiente", Toast.LENGTH_SHORT).show()
            }
        } else {
            if (input.text?.isBlank() == true) {
                Toast.makeText(this, "Ingrese una cantidad", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ingrese una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
