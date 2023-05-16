package com.example.calcimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editTextWeight: EditText //peso
    private lateinit var editTextHeight: EditText //altura
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView
    private lateinit var textViewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextWeight = findViewById(R.id.editTextPeso)
        editTextHeight = findViewById(R.id.editTextAltura)
        buttonCalculate = findViewById(R.id.buttonOk)
        textViewResult = findViewById(R.id.textView)
        textViewName = findViewById(R.id.editTextNome)


        buttonCalculate.setOnClickListener {
            val weight = editTextWeight.text.toString().toDouble() //peso
            val height = editTextHeight.text.toString().toDouble()  //altura
            val bmi = weight / (height * height)
            var mensagem = String.format("Seu IMC é %.2f", bmi)
            //mensagem = textViewName.toString()
            mensagem += imc(bmi)
            textViewResult.text = mensagem
        }

    }
    fun imc(imc: Double): String{
        if(imc < 18.5){
            return "Desnutrição"
        }
        else if(imc >= 18.6 && imc < 24.5){
            return "Peso normal"
        }
        else if(imc >= 25 && imc < 29.9){
            return "Sobrepeso"
        }
        else if(imc >= 30 && imc < 39.9){
            return "Obesidade"
        }
        else if(imc >= 40){
            return "Obesidade Morbida"
        }
        return ""
    }
}