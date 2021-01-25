package com.example.oshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class CartActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val actionbar = supportActionBar
        actionbar!!.title = "Keranjang"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)

        val btnCheckout: Button = findViewById(R.id.btn_checkout)
        btnCheckout.setOnClickListener(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    override fun onClick(v: View?) {

        if (v != null) {
            when (v.id) {
                R.id.btn_checkout -> {
                    Toast.makeText(this, "You ordered this item.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}