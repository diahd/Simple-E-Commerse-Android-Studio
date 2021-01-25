package com.example.oshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import java.util.ArrayList

class GridProductAdapter (
    private val context: Context,
    private val listProduct: ArrayList<Product>
    ): BaseAdapter(){
        private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return listProduct.size
    }

    override fun getItem(position: Int): Any {
        return listProduct[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        // Cek apakah tamplan sudah ada, jika true maka tidak perlu meng-inflate dari layout
        // dan memanggil fungsi findViewById() lagi
        if (convertView == null) {
            view = inflater.inflate(R.layout.home_product, parent, false)

            holder = ViewHolder()
            holder.iconProduct = view.findViewById(R.id.previewIcon) as ImageView
            holder.namaProduct = view.findViewById(R.id.title) as TextView
            holder.hargaProduct =  view.findViewById(R.id.price) as TextView

            view.tag = holder
        }else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val iconProduct = holder.iconProduct
        val namaProduct = holder.namaProduct
        val hargaProduct = holder.hargaProduct

        val product = getItem(position) as Product

        Glide
            .with(context)
            .load(product.photo)
            .centerInside()
            .into(iconProduct)
        namaProduct.text = product.name
        hargaProduct.text = product.price

        return view
    }

    private class ViewHolder {
        lateinit var iconProduct: ImageView
        lateinit var namaProduct: TextView
        lateinit var hargaProduct: TextView
    }
    /*private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.home_product, viewGroup, false)
        return GridViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    fun getItem(position: Int): Any {
        return listProduct[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        val product = listProduct[position]

        Glide.with(holder.itemView.context)
                .load(product.photo)
                .apply(RequestOptions().override(55, 55))
                .into(holder.imgPhoto)

        holder.tvName.text = product.name
        holder.tvPrice.text = product.price

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition]) }
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.previewIcon)
        var tvName: TextView = itemView.findViewById(R.id.title)
        var tvPrice: TextView = itemView.findViewById(R.id.price)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Product)
    }*/
}
