package com.homepageexobe

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.homepageexobe.fragments.BookingFragment
import com.homepageexobe.fragments.CategoryFragment
import com.homepageexobe.fragments.DealsBottomSheetFragment
import com.homepageexobe.fragments.EmptyCartFragment
import com.homepageexobe.fragments.HomeFragment
import com.homepageexobe.fragments.SettingsFragment
import com.homepageexobe.fragments.WishlistFragment

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var menuIcon: ImageView
    lateinit var backIcon: ImageView
    lateinit var closeMenuIcon:ImageView
    lateinit var pageTitle: TextView
    lateinit var homeIcon: LinearLayout
    lateinit var categoryIcon: LinearLayout
    lateinit var bookingIcon: LinearLayout
    lateinit var wishlistIcon: LinearLayout
    lateinit var settingsIcon: LinearLayout
    lateinit var cartIconTop: ImageView
    lateinit var dealsIcon: ImageView
    lateinit var notificationIcon: ImageView
    lateinit var sideMenuDeals: LinearLayout
    lateinit var dropdownIcon: ImageView
    lateinit var drawerDealsOnProducts: TextView
    lateinit var drawerDealsOnServices: TextView

    private var homeFragment: HomeFragment?= null
    private var bookingFragment: BookingFragment?= null
    private var categoryFragment: CategoryFragment?= null
    private var wishlistFragment: WishlistFragment?= null
    private var settingsFragment: SettingsFragment?= null
    private var activeFragment: Fragment? = null

    private var activeFragmentsName = "Home"


        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            homeFragment = HomeFragment.newInstance()
            bookingFragment = BookingFragment.newInstance()
            categoryFragment = CategoryFragment.newInstance()
            wishlistFragment = WishlistFragment.newInstance()
            settingsFragment = SettingsFragment.newInstance()
            activeFragment = homeFragment


            supportFragmentManager.beginTransaction().apply {
                add(R.id.fragment_container, settingsFragment!!).hide(settingsFragment!!)
                add(R.id.fragment_container, wishlistFragment!!).hide(wishlistFragment!!)
                add(R.id.fragment_container, categoryFragment!!).hide(categoryFragment!!)
                add(R.id.fragment_container, bookingFragment!!).hide(bookingFragment!!)
                add(R.id.fragment_container, homeFragment!!).show(homeFragment!!)
            }.commit()
            updateIcon()


//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, HomeFragment())
//            .commit()


            //Actions of the header components

            //On clicking menu icon on header
            drawerLayout = findViewById(R.id.drawerLayout)
            menuIcon = findViewById(R.id.menuIcon)
            closeMenuIcon = findViewById(R.id.closeMenuIcon)

            menuIcon.setOnClickListener {
                drawerLayout.openDrawer(Gravity.LEFT)
            }

            //On clicking cross icon on opened side menu
            closeMenuIcon.setOnClickListener {
                drawerLayout.closeDrawer(Gravity.LEFT)
            }

            //On clicking dropdown icon on deals layout of opened side menu

            sideMenuDeals = findViewById(R.id.sideMenuDeals)
            dropdownIcon = findViewById(R.id.dropdownIcon)
            drawerDealsOnProducts = findViewById(R.id.drawerDealsOnProducts)
            drawerDealsOnServices = findViewById(R.id.drawerDealsOnServices)

            sideMenuDeals.setOnClickListener{
                if (drawerDealsOnProducts.visibility == View.VISIBLE) {
                    // If the views are visible, hide them and rotate the icon
                    dropdownIcon.animate().rotationBy(-180f).start()
                    drawerDealsOnProducts.visibility = View.GONE
                    drawerDealsOnServices.visibility = View.GONE
                } else {
                    // If the views are hidden, show them and rotate the icon
                    dropdownIcon.animate().rotationBy(180f).start()
                    drawerDealsOnProducts.visibility = View.VISIBLE
                    drawerDealsOnServices.visibility = View.VISIBLE
                }
            }


            //On clicking cart icon on top right

            backIcon = findViewById(R.id.backIcon)
            dealsIcon = findViewById(R.id.dealsIcon)
            notificationIcon = findViewById(R.id.notificationIcon)
            cartIconTop = findViewById(R.id.cartIconTop)

            dealsIcon.setOnClickListener{
                dealsIcon.setOnClickListener {
                    val bottomSheetFragment = DealsBottomSheetFragment()
                    bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
                }
            }

            cartIconTop.setOnClickListener{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, EmptyCartFragment())
                    .addToBackStack(null)
                    .commit()
                activeFragmentsName = "My Cart"
                updateTitle()
                updateIcon()
                updateHeader()

                activeFragment?.let {
                    activeFragmentsName = when (it) {
                        is HomeFragment -> "Home"
                        is BookingFragment -> "Booking"
                        is CategoryFragment -> "Category"
                        is WishlistFragment -> "Wishlist"
                        is SettingsFragment -> "Settings"

                        else -> ""
                    }
                }

            }

            //On clicking back icon in header to navigate to previous page
            backIcon.setOnClickListener {
                supportFragmentManager.popBackStack()
                activeFragment!!.onResume()
                updateTitle()
                updateHeader()
            }

            //Actions of the footer components

            //On clicking home icon in bottom nav
            homeIcon = findViewById(R.id.homeIcon)

//            homeIcon.setOnClickListener {
//                supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragment_container, HomeFragment())
//                    .addToBackStack(null)
//                    .commit()
//            }

            homeIcon.setOnClickListener  {
                activeFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .hide(it)
                        .show(homeFragment!!)
                        .commit()
                }
                activeFragment = homeFragment
                homeFragment!!.onResume()
                activeFragmentsName = "Home"
                updateTitle()
                updateIcon()
                updateHeader()
            }

            //On clicking booking icon in bottom nav

            bookingIcon = findViewById(R.id.bookingIcon)

            bookingIcon.setOnClickListener{
                activeFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .hide(it)
                        .show(bookingFragment!!)
                        .commit()
                }
                activeFragment = bookingFragment
                bookingFragment!!.onResume()
                activeFragmentsName = "Booking"
                updateTitle()
                updateIcon()
                updateHeader()
            }

            //On clicking category icon in bottom nav

            categoryIcon = findViewById(R.id.categoryIcon)

            categoryIcon.setOnClickListener {
                activeFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .hide(it)
                        .show(categoryFragment!!)
                        .commit()
                }
                activeFragment = categoryFragment
                categoryFragment!!.onResume()
                activeFragmentsName = "Category"
                updateTitle()
                updateIcon()
                updateHeader()
            }

            //On clicking wishlist icon in bottom nav

            wishlistIcon = findViewById(R.id.wishlistIcon)

            wishlistIcon.setOnClickListener {
                activeFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .hide(it)
                        .show(wishlistFragment!!)
                        .commit()
                }
                activeFragment = wishlistFragment
                wishlistFragment!!.onResume()
                activeFragmentsName = "Wishlist"
                updateTitle()
                updateIcon()
                updateHeader()
            }

            //On clicking settings icon in bottom nav

            settingsIcon = findViewById(R.id.settingsIcon)

            settingsIcon.setOnClickListener {
                activeFragment?.let {
                    supportFragmentManager.beginTransaction()
                        .hide(it)
                        .show(settingsFragment!!)
                        .commit()
                }
                activeFragment = settingsFragment
                settingsFragment!!.onResume()
                activeFragmentsName = "Settings"
                updateTitle()
                updateIcon()
                updateHeader()
            }


            //Exiting the app on pressing the back button
            val callback = object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
                    if (currentFragment is EmptyCartFragment) {
                        // If the current fragment is EmptyCartFragment, pop the back stack
                        supportFragmentManager.popBackStack()
                        updateTitle()
                        updateHeader()
                    } else {
                        // If any other fragment is visible, handle the back press based on your requirement
                        when (activeFragment) {
                            bookingFragment, categoryFragment, wishlistFragment, settingsFragment -> {
                                supportFragmentManager.beginTransaction()
                                    .hide(activeFragment!!)
                                    .show(homeFragment!!)
                                    .commit()
                                activeFragment = homeFragment
                                homeFragment!!.onResume()
                                activeFragmentsName = "Home"
                                updateTitle()
                                updateIcon()
                                updateHeader()
                            }
                            homeFragment -> {
//                                var backPressedOnce = false
//                                    if (backPressedOnce) {
////                                        super.handleOnBackPressed()
//                                        finishAfterTransition()
//                                    } else {
//                                        backPressedOnce = true
//                                        Toast.makeText(this@MainActivity, "Press back again to exit", Toast.LENGTH_SHORT).show()
//                                        // Reset backPressedOnce after a delay
//                                        Handler().postDelayed({ backPressedOnce = false }, 5000)
//                                    }
                                finishAfterTransition()
                            }

                            else -> {
                                finishAfterTransition()
                            }
                        }
                    }
                }
            }


            onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onResume() {
        super.onResume()
        updateIcon()
        updateTitle()
    }

    override fun onPause() {
        super.onPause()
        updateIcon()
        updateTitle()
    }

    override fun onDestroy() {
        super.onDestroy()
        homeFragment =  null
        bookingFragment =  null
        categoryFragment =  null
        wishlistFragment =  null
        settingsFragment =  null
    }

    //Update the title dynamically
    fun updateTitle() {
        pageTitle = findViewById(R.id.pageTitle)
        pageTitle.text = activeFragmentsName
    }

    //Update the bottom nav icons state(hollow/filled) dynamically
    fun updateIcon() {
        val footerLayout = findViewById<LinearLayout>(R.id.footer)
        val tabHome = footerLayout.findViewById<LinearLayout>(R.id.homeIcon).findViewById<ImageView>(R.id.home_img)
        val tabBooking = footerLayout.findViewById<LinearLayout>(R.id.bookingIcon).findViewById<ImageView>(R.id.booking_img)
        val tabCategory = footerLayout.findViewById<LinearLayout>(R.id.categoryIcon).findViewById<ImageView>(R.id.category_img)
        val tabWishlist = footerLayout.findViewById<LinearLayout>(R.id.wishlistIcon).findViewById<ImageView>(R.id.wishlist_img)
        val tabSettings = footerLayout.findViewById<LinearLayout>(R.id.settingsIcon).findViewById<ImageView>(R.id.settings_img)


        when (activeFragmentsName) {
            "Home" -> {
                tabHome.setImageResource(R.drawable.homefilledicon)
                tabBooking.setImageResource(R.drawable.booking_icon_hollow)
                tabCategory.setImageResource(R.drawable.category_icon_hollow)
                tabWishlist.setImageResource(R.drawable.wishlist_icon_hollow)
                tabSettings.setImageResource(R.drawable.settings_icon_hollow)
            }
            "Booking" -> {
                tabHome.setImageResource(R.drawable.home_icon_hollow)
                tabBooking.setImageResource(R.drawable.bookingfilledicon)
                tabCategory.setImageResource(R.drawable.category_icon_hollow)
                tabWishlist.setImageResource(R.drawable.wishlist_icon_hollow)
                tabSettings.setImageResource(R.drawable.settings_icon_hollow)
            }
            "Category" -> {
                tabHome.setImageResource(R.drawable.home_icon_hollow)
                tabBooking.setImageResource(R.drawable.booking_icon_hollow)
                tabCategory.setImageResource(R.drawable.categoryfilledicon)
                tabWishlist.setImageResource(R.drawable.wishlist_icon_hollow)
                tabSettings.setImageResource(R.drawable.settings_icon_hollow)
            }
            "Wishlist" -> {
                tabHome.setImageResource(R.drawable.home_icon_hollow)
                tabBooking.setImageResource(R.drawable.booking_icon_hollow)
                tabCategory.setImageResource(R.drawable.category_icon_hollow)
                tabWishlist.setImageResource(R.drawable.wishlistfilledicon)
                tabSettings.setImageResource(R.drawable.settings_icon_hollow)
            }
            "Settings" -> {
                tabHome.setImageResource(R.drawable.home_icon_hollow)
                tabBooking.setImageResource(R.drawable.booking_icon_hollow)
                tabCategory.setImageResource(R.drawable.category_icon_hollow)
                tabWishlist.setImageResource(R.drawable.wishlist_icon_hollow)
                tabSettings.setImageResource(R.drawable.settingsfilledicon)
            }
        }
    }

    fun updateHeader(){
        if(activeFragmentsName == "My Cart"){
            backIcon.visibility = View.VISIBLE
            menuIcon.visibility = View.GONE
            dealsIcon.visibility = View.GONE
            notificationIcon.visibility = View.GONE
            cartIconTop.visibility = View.GONE
        } else{
            backIcon.visibility = View.GONE
            menuIcon.visibility = View.VISIBLE
            dealsIcon.visibility = View.VISIBLE
            notificationIcon.visibility = View.VISIBLE
            cartIconTop.visibility = View.VISIBLE
        }
    }


}
