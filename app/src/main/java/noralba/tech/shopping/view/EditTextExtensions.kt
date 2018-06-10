package noralba.tech.shopping.view

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.view.inputmethod.InputMethodManager.SHOW_IMPLICIT
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.inputmethod.InputMethodManager


fun EditText.afterTextChanged(listener: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            listener.invoke(editable.toString())
        }
    })
}