package com.example.calcimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //Iniciar as variáveis
    private lateinit var editTextWeight: EditText //peso
    private lateinit var editTextHeight: EditText //altura
    private lateinit var buttonCalculate: Button
    private lateinit var textViewResult: TextView
    private lateinit var textViewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Buscar as informações no layout através do id
        editTextWeight = findViewById(R.id.editTextPeso)
        editTextHeight = findViewById(R.id.editTextAltura)
        buttonCalculate = findViewById(R.id.buttonOk)
        textViewResult = findViewById(R.id.textView)
        textViewName = findViewById(R.id.editTextNome)


        //Configuração do listener para o botão "Calcular"
        buttonCalculate.setOnClickListener {
            //verificando se os campos altura e peso foram preenchidas
            if(editTextHeight.text.isNullOrEmpty() == false && editTextWeight.text.isNullOrEmpty() == false){
                //convertendo os dados recebido e convertendo em dado numericos
                val weight = editTextWeight.text.toString().toDouble() //peso
                var height = editTextHeight.text.toString().toDouble()  //altura
                //Verifica se o usuário inseriu um número inteiro ou maior que 3 e divide por 100
                if(height % 1.0 == 0.0 && height > 3){
                    height /= 100
                }
                // calculo do imc de acordo com a formula
                val bmi = weight / (height * height)
                //var mensagem = String.format("Seu IMC é %.2f", bmi)
                //mensagem = textViewName.toString()
                //mensagem += imc(bmi)

                // envia para o layout via textview o resultado da categoria do imc através de função imc
                textViewResult.text = imc(bmi, textViewName.text.toString())

            } else {
                //caso o usuário não tenha preenchido os dois campos irá disparar uma menságem pedindo para preencher
                Toast.makeText(this, "Prencher os campos pesso e altura", Toast.LENGTH_SHORT).show()
                //textViewResult.text = "Preencher os campos de peso e altura"
            }
        }

    }
    //função que recebe via parametro o imc e o nome e retorna o resultado do índice de massa corpórea
    fun imc(imc: Double, nome: String): String{
        //iniciando uma variável para guardar a categoria de massa corpórea
        var str = ""
        //aqui vai os if e else aninhados para verificar que é o tipo de massa corpórea
        if(imc < 18.5){
            str = "Desnutrição"
        }
        else if(imc >= 18.6 && imc < 24.99){
            str = "Peso normal"
        }
        else if(imc >= 25 && imc < 29.99){
            str = "Sobrepeso"
        }
        else if(imc >= 30 && imc < 39.99){
            str = "Obesidade"
        }
        else if(imc >= 40){
            str = "Obesidade Morbida"
        }
        //retorna o parâmetro do nome o valor do imc recebido e já calculado e também a variavel com o tipo de massa
        return "$nome\n${String.format("Seu IMC é %.2f", imc)}\n$str"
    }
}