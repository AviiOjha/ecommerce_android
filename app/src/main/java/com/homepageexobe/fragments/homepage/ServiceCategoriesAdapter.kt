package com.homepageexobe.fragments.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.R
import com.homepageexobe.fragments.HomeFragment

class ServiceCategoriesAdapter(context: HomeFragment, val serviceCatList: ArrayList<ServiceCategories>):
    RecyclerView.Adapter<ServiceCategoriesAdapter.ServiceViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.service_categories, parent, false)
        return ServiceViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val item = serviceCatList[position]
        holder.serviceImage.setImageResource(item.serviceImage)
        holder.title.text = item.title
        holder.description.text = item.description
    }

    override fun getItemCount(): Int {
        return serviceCatList.size
    }

    inner class ServiceViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val serviceImage: ImageView = itemView.findViewById(R.id.product_img)
        val title: TextView = itemView.findViewById(R.id.product_title)
        val description: TextView = itemView.findViewById(R.id.product_desc)
    }
}