package com.benmohammad.reelzapp.util.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.method.ScrollingMovementMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.benmohammad.reelzapp.R

class NumberedEditText : AppCompatEditText {

    val rect = Rect()

    init {

        val numberedEditText: NumberedEditText = this
        val paint = Paint()
        paint.setStyle(Paint.Style.FILL)
        paint.setColor(resources.getColor(R.color.white))
        paint.textSize = 24f
        setHorizontallyScrolling(false)
        movementMethod = ScrollingMovementMethod()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var baseline = lineHeight
        for (i in 0..lineCount) {
            canvas.drawText((i + 1).toString(), rect.left.toFloat(), baseline.toFloat(), paint)
            baseline += lineCount
        }
    }

}