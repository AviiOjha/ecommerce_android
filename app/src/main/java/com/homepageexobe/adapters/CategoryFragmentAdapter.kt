package com.homepageexobe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.dataclass.CategoryFragmentModel
import com.homepageexobe.R
import com.homepageexobe.fragments.CategoryFragment

class CategoryFragmentAdapter (context: CategoryFragment, val categoryFragmentList: ArrayList<CategoryFragmentModel>) :
    RecyclerView.Adapter<CategoryFragmentAdapter.CategoryFragmentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryFragmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_for_fragment_categories, parent, false)
        return CategoryFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryFragmentViewHolder, position: Int) {
        val item = categoryFragmentList[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return categoryFragmentList.size
    }


    inner class CategoryFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.baby_image_fragment)
        val title: TextView = itemView.findViewById(R.id.baby_text_fragment)
    }
}
