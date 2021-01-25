package com.example.oshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.ListView
import com.synnapps.carouselview.CarouselView
import com.synnapps.carouselview.ImageListener

class MainActivity : AppCompatActivity() {

    private lateinit var carouselView: CarouselView
    private lateinit var rvProduct: ListView
    private var list: ArrayList<Product> = arrayListOf()

    //membuat carousel
    private val sampleImages = intArrayOf(
        R.drawable.slider3,
        R.drawable.slider2,
        R.drawable.slider1
    )

    //carousel
    private val imagesListener = ImageListener { position: Int, imageView: ImageView ->
        imageView.setImageResource(sampleImages[position])
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //inisialisai recycleview
        rvProduct = findViewById(R.id.recyclerView)
        //inisialisasi caorusel
        carouselView = findViewById(R.id.carousel_View)

        carouselView.pageCount = sampleImages.size
        carouselView.setImageListener(imagesListener)

        //menambahkan data di ProductData ke list
        list.addAll(ProductData.listProduct)

        val adapter = GridProductAdapter(this, list)
        rvProduct.adapter = adapter

        rvProduct.setOnItemClickListener { _, _, position, _ ->
            val selectedProduct = list[position]
            val detailIntent = DetailActivity.newIntent(this, selectedProduct)
            startActivity(detailIntent)

            val actionbar = supportActionBar
            actionbar!!.title = "Home"
            actionbar.setDisplayHomeAsUpEnabled(true)
            actionbar.setDisplayHomeAsUpEnabled(true)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }
    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.ic_profile -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.ic_cart -> {
                val moveIntent2 = Intent(this@MainActivity, CartActivity::class.java)
                startActivity(moveIntent2)
            }
            R.id.ic_about -> {
                val moveIntent3 = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent3)
            }
        }
    }
}