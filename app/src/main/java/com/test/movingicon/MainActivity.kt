package com.test.movingicon

import android.app.Activity
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : Activity() {
    lateinit var set: ConstraintSet
    lateinit var constraintLayout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        set = ConstraintSet()
        constraintLayout = findViewById(R.id.activity_constraint)
        set.clone(constraintLayout)
        val editText = findViewById<EditText>(R.id.bias)
        editText.setOnEditorActionListener { v: TextView, actionId: Int, event: KeyEvent? ->
            var handled = false
            if (actionId == EditorInfo.IME_ACTION_GO) {
                set.setHorizontalBias(R.id.icon5g, v.text.toString().toFloat())
                set.applyTo(constraintLayout)
                handled = true
            }
            handled
        }
    }
}