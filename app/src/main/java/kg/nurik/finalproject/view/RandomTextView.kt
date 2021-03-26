package kg.nurik.finalproject.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import kotlin.random.Random

class RandomTextView(context: Context, attributeSet: AttributeSet) :
    AppCompatTextView(context, attributeSet) {

    init {
        randomInt()
    }

    private fun randomInt() {
        this.text = Random.nextInt(0, 20).toString()
    }
}