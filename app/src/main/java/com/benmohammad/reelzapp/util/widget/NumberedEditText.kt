package com.benmohammad.reelzapp.util.widget

import android.R
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.text.method.ScrollingMovementMethod
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class NumberedEditText(context: Context, attrs: AttributeSet
) : AppCompatEditText(context, attrs) {

    private var rect: Rect? = null
    private var paint: Paint? = null
    var numberedEditText: NumberedEditText? = null

    init {
        numberedEditText = this
        rect = Rect()
        paint = Paint()
        paint!!.style = Paint.Style.FILL
        paint!!.color = resources.getColor(R.color.white)
        paint!!.textSize = 24f
        setHorizontallyScrolling(false)
        movementMethod = ScrollingMovementMethod()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var baseLine = baseline
        for (i in 0 until lineCount) {
            canvas.drawText(
                String.format(" %d   ", i + 1),
                rect!!.left.toFloat(),
                baseLine.toFloat(),
                paint!!
            )
            baseLine += lineHeight
        }
    }

}