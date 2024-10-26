package com.homepageexobe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.fragments.homepage.Category
import com.homepageexobe.fragments.homepage.CategoryAdapter
import com.homepageexobe.MainActivity
import com.homepageexobe.fragments.homepage.Product
import com.homepageexobe.fragments.homepage.ProductAdapter
import com.homepageexobe.fragments.homepage.ProductDeal
import com.homepageexobe.fragments.homepage.ProductDealAdapter
import com.homepageexobe.R
import com.homepageexobe.fragments.homepage.ServiceCategories
import com.homepageexobe.fragments.homepage.ServiceCategoriesAdapter
import com.homepageexobe.fragments.homepage.ServiceDeal
import com.homepageexobe.fragments.homepage.ServiceDealAdapter

class HomeFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)

        lateinit var recyclerView: RecyclerView
        lateinit var productDealAdapter: ProductDealAdapter
        lateinit var productDealList: ArrayList<ProductDeal>

        lateinit var categoryAdapter: CategoryAdapter
        lateinit var categoryList: ArrayList<Category>

        lateinit var productAdapter: ProductAdapter
        lateinit var productList: ArrayList<Product>

        lateinit var serviceCatAdapter: ServiceCategoriesAdapter
        lateinit var serviceCatList: ArrayList<ServiceCategories>

        lateinit var serviceDealAdapter: ServiceDealAdapter
        lateinit var serviceDealList: ArrayList<ServiceDeal>

        // Update the title dynamically
//        (activity as MainActivity).updateTitle("Home")

        //Update the bottom tab icon dynamically to be filled white
//        (activity as MainActivity).updateIcon()


        //Recycler view for categories
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_categories)

            categoryList = ArrayList()

            categoryList.add(Category(R.drawable.cat_baby, "Baby"))
            categoryList.add(Category(R.drawable.cat_beauty, "Beauty"))
            categoryList.add(Category(R.drawable.cat_couples, "Couples"))
            categoryList.add(Category(R.drawable.cat_crockery, "Crockery"))
            categoryList.add(Category(R.drawable.cat_toddler, "Toddler"))

        categoryAdapter = CategoryAdapter(this, categoryList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = categoryAdapter

        //Recycler View for Product Deals
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_deals)

        productDealList = ArrayList()
        for (i in 1..5) {
            val imageResId: Int = R.drawable.deal_img1
            productDealList.add(ProductDeal(imageResId, "Printed Pure Cotton Suit", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off", "Expiry on:", "2023-07-29 12:01 PM"))
        }
        productDealList.add(ProductDeal(R.drawable.deal_img2, "Printed Pure Cotton Suit", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off", "Expiry on:", "2023-07-29 12:01 PM"))

        productDealAdapter = ProductDealAdapter(this, productDealList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = productDealAdapter

        //Recycler view for Products
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_products)

        productList = ArrayList()

        productList.add(Product(R.drawable.samsung_phone, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        productList.add(Product(R.drawable.washing_machine, "LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        productList.add(Product(R.drawable.samsung_phone, "Samsung fold phone new", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        productList.add(Product(R.drawable.washing_machine, "LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))
        productList.add(Product(R.drawable.washing_machine, "LG washing machine", "Rs 5000.00", "Rs 3750.00", "25% Off"))

        productAdapter = ProductAdapter(this, productList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = productAdapter

        //Recycler view for Service Categories
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_service_categories)

        serviceCatList = ArrayList()

        serviceCatList.add(ServiceCategories(R.drawable.service_cat1, "Cleaning Services", "Cleaning is the process..."))
        serviceCatList.add(ServiceCategories(R.drawable.service_cat2, "Electrical Services", "Electrical services are..."))
        serviceCatList.add(ServiceCategories(R.drawable.service_cat1, "Dancing Classes", "Everyone needs to..."))
        serviceCatList.add(ServiceCategories(R.drawable.service_cat1, "Cleaning Services", "Cleaning is the process..."))
        serviceCatList.add(ServiceCategories(R.drawable.service_cat2, "Electrical Services", "Electrical services are..."))

        serviceCatAdapter = ServiceCategoriesAdapter(this, serviceCatList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = serviceCatAdapter

        //Recycler view for Service Deals
        recyclerView = view.findViewById<RecyclerView>(R.id.rv_service_deals)

        serviceDealList = ArrayList()

        serviceDealList.add(ServiceDeal(R.drawable.service_deal1, "Electrical Services", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off"))
        serviceDealList.add(ServiceDeal(R.drawable.service_deal2, "Cleaning Services", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off"))
        serviceDealList.add(ServiceDeal(R.drawable.service_deal1, "Electrical Services", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off"))
        serviceDealList.add(ServiceDeal(R.drawable.service_deal1, "Printed Pure Cotton Suit", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off"))
        serviceDealList.add(ServiceDeal(R.drawable.service_deal2, "Printed Pure Cotton Suit", "Rs 5000.00", "Rs 3750.00", "Deal Discount:","25% Off"))

        serviceDealAdapter = ServiceDealAdapter(this, serviceDealList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = serviceDealAdapter


        //Click listener on seeAllForCategories

//        val seeAllForCategoryTextView = view.findViewById<TextView>(R.id.seeAllForCategories)
//
//        // Set onClickListener
//        seeAllForCategoryTextView.setOnClickListener {
//            // Navigate to the desired fragment
//            requireActivity().supportFragmentManager.beginTransaction()
//                .replace(R.id.fragment_container, CategoryFragment())
//                .addToBackStack(null) // Add to back stack if needed
//                .commit()
//        }
//        (activity as MainActivity).updateIcon()
//        (activity as MainActivity).updateTitle()
//        (activity as MainActivity).updateHeader()

        return view
    }


}