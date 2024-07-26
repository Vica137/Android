package com.example.calculadora

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculadora.databinding.ActivityMainBinding

//Variables
private lateinit var binding: ActivityMainBinding

class MainActivityBinding : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Variables para operaciones
        var resultado = 0.0
        var suma = false
        var resta = false
        var multiplicacion = false
        var division = false


        binding.ceroButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("0")
        }

        binding.unoButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("1")
        }

        binding.dosButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("2")
        }

        binding.tresButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("3")
        }
        binding.cuatroButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("4")
        }

        binding.cincoButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("5")
        }
        binding.seisButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("6")
        }

        binding.sieteButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("7")
        }
        binding.ochoButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("8")
        }

        binding.nueveButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("9")
        }

        binding.puntoButton.setOnClickListener {
            if(binding.resultadoTextView.text.contains(".")){
                binding.resultadoTextView.text = concatenador(".")
            }
        }
        binding.menosButton.setOnClickListener {
            suma = false
            resta = true
            multiplicacion = false
            division = false
            binding.resultadoTextView.text = concatenador("-")
        }

        binding.masButton.setOnClickListener {
            suma = true
            resta = false
            multiplicacion = false
            division = false
            binding.resultadoTextView.text = concatenador("+")
        }
        binding.divButton.setOnClickListener {
            suma = false
            resta = false
            multiplicacion = false
            division = true
            binding.resultadoTextView.text = concatenador("/")

        }

        binding.porButton.setOnClickListener {
            suma = false
            resta = false
            multiplicacion = true
            division = false
            binding.resultadoTextView.text = concatenador("*")
        }

        binding.porcentajeButton.setOnClickListener {
            binding.resultadoTextView.text = concatenador("%")
            binding.resultadoTextView.text = (binding.resultadoTextView.text.toString().toDouble() * 0.01).toString()

        }

        binding.allCleanButton.setOnClickListener {
            suma = false
            resta = false
            multiplicacion = false
            division = false
            resultado = 0.0
            binding.resultadoTextView.text = concatenador("0")
        }
        binding.masMenosButton.setOnClickListener {
            binding.resultadoTextView.text = (binding.resultadoTextView.text.toString().toDouble() * -1).toString()
        }
    }


}

fun concatenador(entrada: String): String {

    //binding.resultadoTextView.text="${binding.resultadoTextView.text}$entrada"

    //Concatenador opcion 2
    var original = binding.resultadoTextView.text.toString()
    var agregado = entrada
    var concatenado = ""

    if (binding.resultadoTextView.text == "0" ){
        concatenado=agregado
    } else {
        concatenado = original + agregado
    }


    return concatenado
}

