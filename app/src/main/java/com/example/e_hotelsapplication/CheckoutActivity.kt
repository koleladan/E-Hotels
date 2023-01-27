package com.example.e_hotelsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_hotelsapplication.Adapters.menu_adapter
import com.example.e_hotelsapplication.Data.Menu
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityCheckoutBinding
import com.google.firebase.database.DatabaseReference

class CheckoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCheckoutBinding
    private lateinit var adapter:menu_adapter
    private lateinit var database: DatabaseReference
    private lateinit var menulist: ArrayList<Menu>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
//using the same key "RestaurantListData" that was passed in the RestaurantListActivity
        val restaurantListData = intent?.getParcelableExtra<RestaurantListData>("RestaurantListData")


        val actionBar:ActionBar? = supportActionBar
        actionBar?.setTitle(restaurantListData?.name)
        actionBar?.setSubtitle(restaurantListData?.address)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        menulist = ArrayList()
        adapter= menu_adapter(this, menulist)
        binding.recyclerview.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapter


        binding.checkoutbtn.setOnClickListener {

        }
    }
}