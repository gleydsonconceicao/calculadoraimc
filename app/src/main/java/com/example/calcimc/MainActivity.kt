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
            if(editTextHeight.text.isNullOrEmpty() == false && editTextWeight.text.isNullOrEmpty() == false){
                val weight = editTextWeight.text.toString().toDouble() //peso
                var height = editTextHeight.text.toString().toDouble()  //altura
                if(height % 1.0 == 0.0 && height > 3){
                    height /= 100
                }
                val bmi = weight / (height * height)
                //var mensagem = String.format("Seu IMC é %.2f", bmi)
                //mensagem = textViewName.toString()
                //mensagem += imc(bmi)


                textViewResult.text = imc(bmi, textViewName.text.toString())

            } else {
                textViewResult.text = "Preencher os campos de peso e altura"
            }
        }

    }
    fun imc(imc: Double, nome: String): String{
        var str = ""
        if(imc < 18.5){
            str = " Desnutrição"
        }
        else if(imc >= 18.6 && imc < 24.99){
            str = " Peso normal"
        }
        else if(imc >= 25 && imc < 29.99){
            str = " Sobrepeso"
        }
        else if(imc >= 30 && imc < 39.99){
            str = " Obesidade"
        }
        else if(imc >= 40){
            str = " Obesidade Morbida"
        }
        return "$nome\n${String.format("Seu IMC é %.2f", imc)}\n$str"
    }
}