package com.example.oshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val actionbar = supportActionBar
        actionbar!!.title = ""
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnOrder: Button = findViewById(R.id.btn_order)
        btnOrder.setOnClickListener(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true

    }

    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btn_order -> {
                    Toast.makeText(this, "You ordered this item.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

