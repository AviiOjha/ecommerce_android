package com.homepageexobe.adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.R
import com.homepageexobe.fragments.WishlistFragment
import com.homepageexobe.dataclass.WishlistFragmentModel

class WishlistFragmentAdapter (context: WishlistFragment, val wishlistFragmentList: ArrayList<WishlistFragmentModel> ):
RecyclerView.Adapter<WishlistFragmentAdapter.WishlistFragmentViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishlistFragmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_for_fragment_wishlist, parent, false)
        return WishlistFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: WishlistFragmentViewHolder,
        position: Int
    ) {
        val item = wishlistFragmentList[position]
        holder.productImage.setImageResource(item.productImage)
        holder.heartImage.setImageResource(item.heartImage)
        holder.productName.text = item.productName
        holder.t1.text = item.t1
        holder.t2.text = item.t2
        holder.t3.text = item.t3

        holder.t1.paintFlags = holder.t1.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    override fun getItemCount(): Int {
        return wishlistFragmentList.size
    }

    inner class WishlistFragmentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val productImage: ImageView = itemView.findViewById(R.id.product_img)
        val heartImage: ImageView = itemView.findViewById(R.id.wishlist_heart)
        val productName: TextView = itemView.findViewById(R.id.product_title)
        val t1:TextView = itemView.findViewById(R.id.mrp_text)
        val t2:TextView = itemView.findViewById(R.id.deal_price)
        val t3:TextView = itemView.findViewById(R.id.discount_percent)
    }

}