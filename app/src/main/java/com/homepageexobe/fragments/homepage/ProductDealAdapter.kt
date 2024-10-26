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

class ProductDealAdapter(context: HomeFragment, val productDealList: ArrayList<ProductDeal>) :
    RecyclerView.Adapter<ProductDealAdapter.ProductDealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDealViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_deal, parent, false)
        return ProductDealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductDealViewHolder, position: Int) {
        val item = productDealList[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.t1.text = item.t1
        holder.t2.text = item.t2
        holder.t3.text = item.t3
        holder.t4.text = item.t4
        holder.t5.text = item.t5
        holder.t6.text = item.t6

        holder.t1.paintFlags = holder.t1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return productDealList.size
    }

    inner class ProductDealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.product_img)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val t1: TextView = itemView.findViewById(R.id.mrp_text)
        val t2: TextView = itemView.findViewById(R.id.deal_price)
        val t3: TextView = itemView.findViewById(R.id.deal_discount)
        val t4: TextView = itemView.findViewById(R.id.discount_percent)
        val t5: TextView = itemView.findViewById(R.id.expiry_on)
        val t6: TextView = itemView.findViewById(R.id.expiry_date)
    }
}
