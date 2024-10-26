package com.homepageexobe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.MainActivity
import com.homepageexobe.R
import com.homepageexobe.adapters.WishlistFragmentAdapter
import com.homepageexobe.dataclass.WishlistFragmentModel

class WishlistFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = WishlistFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_wishlist, container, false)

        lateinit var recyclerView: RecyclerView
        lateinit var wishlistFragmentAdapter: WishlistFragmentAdapter
        lateinit var wishlistFragmentList: ArrayList<WishlistFragmentModel>

        // Update the title dynamically
//        (activity as MainActivity).updateTitle("Wishlist")

        //Update the bottom tab icon dynamically to be filled white
//        (activity as MainActivity).updateIcon()

        recyclerView = view.findViewById<RecyclerView>(R.id.fragment_wishlist_rv)

        wishlistFragmentList = ArrayList()

        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.samsung_phone, R.drawable.wishlist_heart, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.washing_machine, R.drawable.wishlist_heart,"LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.samsung_phone, R.drawable.wishlist_heart, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.washing_machine, R.drawable.wishlist_heart,"LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.washing_machine, R.drawable.wishlist_heart,"LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.samsung_phone, R.drawable.wishlist_heart, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.samsung_phone, R.drawable.wishlist_heart, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        wishlistFragmentList.add(WishlistFragmentModel(R.drawable.washing_machine, R.drawable.wishlist_heart, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))


        wishlistFragmentAdapter = WishlistFragmentAdapter(this, wishlistFragmentList)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2, RecyclerView.VERTICAL, false)
        recyclerView.adapter = wishlistFragmentAdapter

        return view
    }
}