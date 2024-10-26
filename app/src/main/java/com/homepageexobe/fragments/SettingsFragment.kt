package com.homepageexobe.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.homepageexobe.MainActivity
import com.homepageexobe.R
import com.homepageexobe.adapters.SettingsFragmentAdapter
import com.homepageexobe.dataclass.SettingsFragmentModel

class SettingsFragment: Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = SettingsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        lateinit var recyclerView: RecyclerView
        lateinit var settingsFragmentAdapter: SettingsFragmentAdapter
        lateinit var settingsFragmentList: ArrayList<SettingsFragmentModel>

        // Update the title dynamically
//        (activity as MainActivity).updateTitle("Settings")

        //Update the bottom tab icon dynamically to be filled white
//        (activity as MainActivity).updateIcon()

        recyclerView = view.findViewById<RecyclerView>(R.id.fragment_settings_rv)

        settingsFragmentList = ArrayList()

        settingsFragmentList.add(SettingsFragmentModel(R.drawable.my_profile, "My Profile"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.change_password, "Change Password"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.address, "Addresses"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.order_booking_icon, "Order History"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.product_enquiry, "Product Enquiry"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.faqs, "FAQs"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.about_us, "About Us"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.contact_us, "Contact Us"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.tnc, "Terms and Conditions"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.order_booking_icon, "Privacy Policy"))
        settingsFragmentList.add(SettingsFragmentModel(R.drawable.rate_this_app, "Rate This App"))


        settingsFragmentAdapter = SettingsFragmentAdapter(this, settingsFragmentList)
        recyclerView.adapter = settingsFragmentAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        return view
    }
}