package com.homepageexobe.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.dataclass.BookingFragmentModel
import com.homepageexobe.R
import com.homepageexobe.fragments.BookingFragment

class BookingFragmentAdapter(context: BookingFragment, val bookingFragmentList: ArrayList<BookingFragmentModel> ):
RecyclerView.Adapter<BookingFragmentAdapter.BookingFragmentViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BookingFragmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_for_fragment_booking, parent, false)
        return BookingFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: BookingFragmentViewHolder,
        position: Int
    ) {
        val item = bookingFragmentList[position]
        holder.image.setImageResource(item.image)
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return bookingFragmentList.size
    }

    inner class BookingFragmentViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.cleaning_fragment_img)
        val title: TextView = itemView.findViewById(R.id.cleaning_fragment_text)
    }

}
