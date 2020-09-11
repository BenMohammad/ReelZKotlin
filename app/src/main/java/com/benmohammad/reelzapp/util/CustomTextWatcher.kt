package com.benmohammad.reelzapp.util

import android.R.attr.maxLines
import android.graphics.Color
import android.text.Editable
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.CharacterStyle
import android.text.style.ForegroundColorSpan
import android.widget.Toast
import com.benmohammad.reelzapp.data.model.ColorScheme
import com.benmohammad.reelzapp.util.widget.NumberedEditText
import java.util.regex.Matcher
import java.util.regex.Pattern


class CustomTextWatcher constructor(val e: NumberedEditText): TextWatcher {

    var keyWords = ColorScheme(
        Pattern.compile("\\b(package|transient|strictfp|void|char|short|int|long|double|float|const|static|volatile|byte|boolean|class|interface|native|private|protected|public|final|abstract|synchronized|enum|instanceof|assert|if|else|switch|case|default|break|goto|return|for|while|do|continue|new|throw|throws|try|catch|finally|this|super|extends|implements|import|true|false|null)\\b"),
        Color.CYAN
    )

    var numbers = ColorScheme(
        Pattern.compile("(\\b(\\d*[.]?\\d+)\\b)"),
        Color.YELLOW
    )

    val schemes = arrayOf(keyWords, numbers)


    override fun afterTextChanged(editable: Editable) {
        if (null != e.layout && e.lineCount > 5) {
            e.text?.delete(e.text!!.length - 1, e.text!!.length);
        }
        removeSpans(editable, ForegroundColorSpan::class.java)
            for (scheme in schemes) {
                val m: Matcher = scheme.pattern.matcher(editable)
                while (m.find()) {
                    editable.setSpan(
                        ForegroundColorSpan(scheme.color),
                        m.start(),
                        m.end(),
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
        }


    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    private fun removeSpans(
        e: Editable,
        type: Class<out CharacterStyle>
    ) {
        val spans: Array<out CharacterStyle>? = e.getSpans(0, e.length, type)
        if (spans != null) {
            for (span in spans) {
                e.removeSpan(span)
            }
        }
    }
}