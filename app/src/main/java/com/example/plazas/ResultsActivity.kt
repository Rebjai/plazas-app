package com.example.plazas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
//        Llamar a la función setResults() en el momento de creación
        setResults()

    }
    private fun setResults() {
//        se guarda el intent en intentObject y de éste se obtiene el valor del radio, el cual es un Double,
//        usando .getDoubleExtra() y se hacen los cálculos que se mostrarán, calculando el area disponible
//        con la función calculateArea()
        val intentObject: Intent = intent
        val radio = intentObject.getDoubleExtra("radio", 1.0)
        val diam = radio * 2
        val area = calculateArea(radio.toString().toDouble())

//        Se obtienen los elementos que necesitamos manipular de la vista, incluyendo el elemento Canvas
        val radioResult : TextView = findViewById(R.id.tvRadio)
        val diamResult : TextView = findViewById(R.id.tvDiametro)
        val areaResult : TextView = findViewById(R.id.tvArea)
        val canvasObj : CanvasView = findViewById(R.id.canvasRad)

//        Se presentan los resultados en la vista modificando el texto de los elementos
        radioResult.text = "Radio : $radio m"
        diamResult.text = "Diámetro : $diam m"
        areaResult.text = "Área : $area m²"

//        Se usa el método .setRadiusCircle() del elemento CanvasView para ajustar el diámetro del círculo dibujado
        canvasObj.setRadiusCircle(radio)

    }
    private fun calculateArea(area : Double): Double {
//        Se regresa el resultado del area del radio dado menos el area de las bases de las farolas
        var areaPlace : Double = Math.pow(area,2.0) * Math.PI
        var areaLamps : Double = Math.pow(1.0,2.0) * Math.PI * 7.0
        return areaPlace - areaLamps
    }

}