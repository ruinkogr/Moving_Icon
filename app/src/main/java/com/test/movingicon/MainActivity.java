package com.test.movingicon;

import android.app.Activity;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

public class MainActivity extends Activity {
	private ConstraintSet set;
	private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        set = new ConstraintSet();
        constraintLayout = findViewById(R.id.activity_constraint);
        set.clone(constraintLayout);
        EditText editText = findViewById(R.id.bias);
        editText.setOnEditorActionListener((v, actionId, event) -> {
            boolean handled = false;
            if (actionId == EditorInfo.IME_ACTION_GO) {
                set.setHorizontalBias(R.id.icon5g, Float.parseFloat(v.getText().toString()));
                set.applyTo(constraintLayout);
                handled = true;
            }
            return handled;
        });
    }
}