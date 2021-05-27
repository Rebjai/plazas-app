package com.example.plazas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun computeArea(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
//        Se obtienen los elementos de la vista
        val txtArea: TextInputEditText = findViewById(R.id.radioPlaza)
        val txtResult: TextView = findViewById(R.id.resultText)
        val radioVal: Double
        try {
//            Se convierte el valor del txtArea a un double, después se valida que el radio sea
//            entre 100 y 300 metros de radio, haciendo el intent correspondiente enviando el valor
//            de el radio con el método .putExtra(), se muestra un mensaje de error en caso de no
//            haber cumplido la condición o en caso que se haya producido un error
            radioVal = txtArea.text.toString().toDouble()
            if (validateInput(radioVal)) {
                val intent: Intent = Intent(this, ResultsActivity::class.java)
                intent.putExtra("radio",radioVal)
                startActivity(intent)
            }
            else{
                txtResult.text = "Por favor introduzca un número entre 100 y 300"

            }
        }catch (error:NumberFormatException){
            txtResult.text = "Por favor introduzca un número entre 100 y 300"
        }
        return
    }

    fun validateInput(num: Double): Boolean {
            return !(num < 100 || num > 300)
    }

}