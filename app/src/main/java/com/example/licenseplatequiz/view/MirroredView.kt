package com.example.licenseplatequiz.view

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet

class MirroredView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : androidx.appcompat.widget.AppCompatTextView(context, attrs, defStyleAttr) {

    private var mirrorText: Boolean = false // Flag to control mirroring

    fun setText(text: String, mirror: Boolean = false) {
        this.mirrorText = mirror
        if (mirror) {
            super.setText(text.reversed()) // Reverse the text for mirroring
        } else {
            super.setText(text)
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (mirrorText) {
            canvas.save()
            canvas.scale(-1f, 1f, width / 2f, 0f) // Mirror horizontally
        }
        super.onDraw(canvas) // Let TextView handle text layout and drawing
        if (mirrorText) {
            canvas.restore()
        }
    }
}