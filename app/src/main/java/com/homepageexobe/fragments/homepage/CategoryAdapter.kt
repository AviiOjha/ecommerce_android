package com.homepageexobe.fragments.homepage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.R
import com.homepageexobe.fragments.HomeFragment

class CategoryAdapter(context: HomeFragment, val cat_list: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.categories_list, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = cat_list[position]
        holder.cat_image.setImageResource(item.cat_image)
        holder.cat_name.text = item.cat_name
    }

    override fun getItemCount(): Int {
        return cat_list.size
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cat_image: ImageView = itemView.findViewById(R.id.baby_image)
        val cat_name: TextView = itemView.findViewById(R.id.baby_text)
    }
}
