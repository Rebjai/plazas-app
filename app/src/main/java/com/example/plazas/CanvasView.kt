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
    var radius:Float = 100f
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint: Paint = Paint()
//        val color1: Color = Color().
        val paint2: Paint = Paint()
        paint.setColor(Color.argb(255,100,200,100))
        paint2.setColor(Color.DKGRAY)
        paint2.textSize = 30F
        paint2.textAlign = Paint.Align.CENTER
        val maxSize = width/2
        val circleRad = maxSize * (radius/300f)/1


        canvas?.drawCircle(width/2f,height/5f*3,circleRad,paint)
        canvas?.drawText("$radius m de radio",width/2f, height/5f*3, paint2)


    }
    public fun setRadiusCircle(n : Double){
        this.radius = n.toFloat()
    }
}
