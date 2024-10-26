package com.homepageexobe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.adapters.CategoryFragmentAdapter
import com.homepageexobe.dataclass.CategoryFragmentModel
import com.homepageexobe.MainActivity
import com.homepageexobe.R

class CategoryFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = CategoryFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_categories, container, false)

        lateinit var recyclerView: RecyclerView

        lateinit var categoryFragmentAdapter: CategoryFragmentAdapter
        lateinit var categoryFragmentList: ArrayList<CategoryFragmentModel>

        // Update the title dynamically
//        (activity as MainActivity).updateTitle("Categories")

        //Update the bottom tab icon dynamically to be filled white
//        (activity as MainActivity).updateIcon()

        recyclerView = view.findViewById<RecyclerView>(R.id.fragment_categories_rv)

        categoryFragmentList = ArrayList()

        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_beauty, "Beauty"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_baby, "Baby"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_toddler, "Toddler"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_couples, "Couples"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_crockery, "Crockery"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_electronics, "Electronics"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_beauty, "Beauty"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_baby, "Baby"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_toddler, "Toddler"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_couples, "Couples"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_crockery, "Crockery"))
        categoryFragmentList.add(CategoryFragmentModel(R.drawable.cat_electronics, "Electronics"))

        categoryFragmentAdapter = CategoryFragmentAdapter(this, categoryFragmentList)
        recyclerView.adapter = categoryFragmentAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        return view
    }
}