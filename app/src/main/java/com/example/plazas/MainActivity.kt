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
//        print(view)
        val txtArea: TextInputEditText = findViewById(R.id.radioPlaza)
        val txtResult: TextView = findViewById(R.id.resultText)
        val radioVal: Double
        try {
            radioVal = txtArea.text.toString().toDouble()
            if (validateInput(radioVal)) {
//                txtResult.text = "El area de pasto a plantar es de " + calculateArea(radioVal) + " metros cuadrados"
                val intent: Intent = Intent(this, ResultsActivity::class.java)
                intent.putExtra("radio",radioVal)
                startActivity(intent)
            }
            else{
                txtResult.text = "Por favor introduzca un número entre 100 y 300"
//
            }
        }catch (error:NumberFormatException){
            txtResult.text = "Por favor introduzca un número entre 100 y 300"
        }




        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        return 

    }
    fun validateInput(num: Double): Boolean {
            return !(num < 100 || num > 300)
    }
    fun calculateArea(area : Double): Double {
//        var doble : Double = 2.0
        var areaPlace : Double = Math.pow(area,2.0) * Math.PI
        var areaLamps : Double = Math.pow(1.0,2.0) * Math.PI * 7.0
        return areaPlace - areaLamps
    }

}