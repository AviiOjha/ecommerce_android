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

class ServiceDealAdapter (context: HomeFragment, private val serviceDealList: ArrayList<ServiceDeal>):
    RecyclerView.Adapter<ServiceDealAdapter.ServiceDealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceDealViewHolder {
        val itemView  = LayoutInflater.from(parent.context).inflate(R.layout.service_deal, parent, false)
        return ServiceDealViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ServiceDealViewHolder, position: Int) {
        val item = serviceDealList[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
        holder.t1.text = item.t1
        holder.t2.text = item.t2
        holder.t3.text = item.t3
        holder.t4.text = item.t4

        holder.t1.paintFlags = holder.t1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return serviceDealList.size
    }

    inner class ServiceDealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.product_img)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val t1: TextView = itemView.findViewById(R.id.mrp_text)
        val t2: TextView = itemView.findViewById(R.id.deal_price)
        val t3: TextView = itemView.findViewById(R.id.deal_discount)
        val t4: TextView = itemView.findViewById(R.id.discount_percent)
    }

}