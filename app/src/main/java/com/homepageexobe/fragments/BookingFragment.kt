package com.homepageexobe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.adapters.BookingFragmentAdapter
import com.homepageexobe.dataclass.BookingFragmentModel
//import com.homepageexobe.MainActivity
import com.homepageexobe.R

class BookingFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = BookingFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_booking, container, false)

        lateinit var bookingFragmentAdapter: BookingFragmentAdapter

        // Update the title dynamically
//        (activity as MainActivity).updateTitle("Booking")

        //Update the bottom tab icon dynamically to be filled white
//        (activity as MainActivity).updateIcon()

        val recyclerView : RecyclerView = view.findViewById(R.id.fragment_booking_rv)

        val bookingFragmentList: ArrayList<BookingFragmentModel> = ArrayList()

        bookingFragmentList.add(BookingFragmentModel(R.drawable.cleaning_booking, "Cleaning"))
        bookingFragmentList.add(BookingFragmentModel(R.drawable.dancing_booking, "Dancing"))
        bookingFragmentList.add(BookingFragmentModel(R.drawable.electrical_booking, "Electrical"))
        bookingFragmentList.add(BookingFragmentModel(R.drawable.hair_salon_booking, "Hair Salon"))
        bookingFragmentList.add(BookingFragmentModel(R.drawable.unisex_salon_booking, "Unisex Salon"))
        bookingFragmentList.add(BookingFragmentModel(R.drawable.plumbing_booking, "Plumbing"))

        bookingFragmentAdapter = BookingFragmentAdapter(BookingFragment(), bookingFragmentList)
        recyclerView.adapter = bookingFragmentAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)


        return view
    }
}