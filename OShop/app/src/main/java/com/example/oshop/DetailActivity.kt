package com.example.oshop

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity(), View.OnClickListener {

    companion object{

        const val EXTRA_nama = "nama"
        const val EXTRA_photo = "foto"
        const val EXTRA_price = "price"
        const val EXTRA_sold = "sold"
        const val EXTRA_stock = "stock"
        const val EXTRA_size = "size"
        const val EXTRA_material = "material"
        const val EXTRA_detail = "detail"

        fun newIntent(context: Context, product: Product): Intent{
            val detailIntent = Intent(context, DetailActivity::class.java)

            detailIntent.putExtra(EXTRA_nama, product.name)
            detailIntent.putExtra(EXTRA_photo, product.photo)
            detailIntent.putExtra(EXTRA_price, product.price)
            detailIntent.putExtra(EXTRA_sold, product.sold)
            detailIntent.putExtra(EXTRA_stock, product.stock)
            detailIntent.putExtra(EXTRA_size, product.size)
            detailIntent.putExtra(EXTRA_material, product.material)
            detailIntent.putExtra(EXTRA_detail, product.detail)

            return detailIntent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnBeli = findViewById<Button>(R.id.btnPurchase)
        btnBeli.setOnClickListener(this)

        val btnKeranjang = findViewById<ImageButton>(R.id.btnkeranjang)
        btnKeranjang.setOnClickListener(this)

        val prphoto = findViewById<ImageView>(R.id.previewIcon)
        val prnama = findViewById<TextView>(R.id.title2)
        val prprice = findViewById<TextView>(R.id.productPrice2)
        val prsold = findViewById<TextView>(R.id.sold2)
        val prstock = findViewById<TextView>(R.id.stok2)
        val prsize = findViewById<TextView>(R.id.size2)
        val prmaterial = findViewById<TextView>(R.id.bahan2)
        val prdetail = findViewById<TextView>(R.id.keterangan2)

        val prphoto2 = intent.extras?.getInt(EXTRA_photo)
        val prnama2 = intent.extras?.getString(EXTRA_nama)
        val prprice2 = intent.extras?.getString(EXTRA_price)
        val prsold2 = intent.extras?.getString(EXTRA_sold)
        val prstock2 = intent.extras?.getString(EXTRA_stock)
        val prsize2 = intent.extras?.getString(EXTRA_size)
        val prmaterial2 = intent.extras?.getString(EXTRA_material)
        val prdetail2 = intent.extras?.getString(EXTRA_detail)

        Glide
            .with(this)
            .load(prphoto2)
            .centerCrop()
            .into(prphoto)

        prnama.text = prnama2.toString()
        prprice.text = prprice2.toString()
        prsold.text = prsold2.toString()
        prstock.text = prstock2.toString()
        prsize.text = prsize2.toString()
        prmaterial.text = prmaterial2.toString()
        prdetail.text = prdetail2.toString()

        val actionbar = supportActionBar
        actionbar!!.title = ""
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btnPurchase -> {
                    val moveIntent = Intent(this@DetailActivity, FormActivity::class.java)
                    startActivity(moveIntent)
                }
                R.id.btnkeranjang -> {
                    Toast.makeText(this, "Dimasukkan ke keranjang.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}