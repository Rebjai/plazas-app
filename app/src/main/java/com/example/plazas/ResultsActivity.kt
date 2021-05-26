package com.example.plazas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)
        val intentObject: Intent = intent
        val radio = intentObject.getDoubleExtra("radio", 1.0)
        print(radio)
        val diam = radio * 2
        val area = calculateArea(radio.toString().toDouble())

        val radioResult : TextView = findViewById(R.id.tvRadio)
        val diamResult : TextView = findViewById(R.id.tvDiametro)
        val areaResult : TextView = findViewById(R.id.tvArea)
        val canvasObj : CanvasView = findViewById(R.id.canvasRad)

        radioResult.text = "Radio : " + radio.toString() + " m"
        diamResult.text = "Diámetro : "+ diam.toString() + " m"
        areaResult.text = "Área : "+ area.toString() + " m²"
        canvasObj.setRadiusCircle(radio)
        print(diam)
        print(area)
    }
    fun calculateArea(area : Double): Double {
//        var doble : Double = 2.0
        var areaPlace : Double = Math.pow(area,2.0) * Math.PI
        var areaLamps : Double = Math.pow(1.0,2.0) * Math.PI * 7.0
        return areaPlace - areaLamps
    }
//    constructor(){
//
//    }
}