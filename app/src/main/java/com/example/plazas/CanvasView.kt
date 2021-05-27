package com.example.plazas

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var radius:Float = 100f
    private val paint = Paint()
    private val paint2 = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

 //        Se configuran los estilos de pintado de cada Paint que usaremos
        paint.setColor(Color.argb(255,100,200,100))
        paint2.setColor(Color.DKGRAY)
        paint2.textSize = 30F
        paint2.textAlign = Paint.Align.CENTER

//        Se define el tamaño máximo como el tamaño del ancho del dispositivo dividido entre 2
        val maxSize = width/2
        val circleRad = maxSize * (radius/300f)/1

//        Se pinta el círculo usando los valores de circleRad y la Paint llamada paint
//        Se dibuja el text que dice el radio con la paint2
        canvas?.drawCircle(width/2f,height/5f*3,circleRad,paint)
        canvas?.drawText("$radius m de radio",width/2f, height/5f*3, paint2)

    }

    fun setRadiusCircle(n : Double){
        this.radius = n.toFloat()
    }
}
