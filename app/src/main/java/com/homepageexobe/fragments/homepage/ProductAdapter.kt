package com.homepageexobe.fragments.homepage

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.R
import com.homepageexobe.fragments.HomeFragment

class ProductAdapter(context: HomeFragment, val productList: ArrayList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.products_list, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]
        holder.productImage.setImageResource(item.productImage)
        holder.productName.text = item.productName
        holder.t1.text = item.t1
        holder.t2.text = item.t2
        holder.t3.text = item.t3

        holder.t1.paintFlags = holder.t1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.product_img)
        val productName: TextView = itemView.findViewById(R.id.product_title)
        val t1: TextView = itemView.findViewById(R.id.mrp_text)
        val t2: TextView = itemView.findViewById(R.id.deal_price)
        val t3: TextView = itemView.findViewById(R.id.discount_percent)
    }
}
