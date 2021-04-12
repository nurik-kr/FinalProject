package kg.nurik.finalproject.view

import android.app.Activity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

fun View.hideKeyboardFrom() {
    val imn: InputMethodManager =
        context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imn.hideSoftInputFromWindow(this.windowToken, 0)
}

fun TextInputEditText.search(text: (request: String) -> Unit) {
    this.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            this.hideKeyboardFrom()
            text.invoke(this.text.toString())
            return@OnEditorActionListener true
        }
        false
    })
}