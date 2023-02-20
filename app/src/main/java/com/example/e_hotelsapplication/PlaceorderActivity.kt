package com.example.e_hotelsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityPlaceorderBinding

class PlaceorderActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaceorderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaceorderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantListData = intent.getParcelableExtra<RestaurantListData>("RestaurantListData")

        val  actionBar:ActionBar? = supportActionBar
        actionBar?.setTitle(restaurantListData?.name)
        actionBar?.setSubtitle(restaurantListData?.address)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        binding.btnorder.setOnClickListener {

        }
        binding.switchdelivery.setOnCheckedChangeListener{ buttonview, isChecked ->

            if (isChecked){
                binding.address.visibility = View.VISIBLE
                binding.city.visibility = View.VISIBLE
                binding.state.visibility = View.VISIBLE
                binding.zip.visibility = View.VISIBLE
                binding.deliverycharge.visibility = View.VISIBLE
                binding.delprice.visibility = View.VISIBLE
            }else{
                binding.address.visibility = View.GONE
                binding.city.visibility = View.GONE
                binding.zip.visibility = View.GONE
                binding.state.visibility= View.GONE
                binding.deliverycharge.visibility = View.GONE
                binding.delprice.visibility = View.GONE
            }

        }
        placeOrderRecyclerView()
    }

    private fun placeOrderRecyclerView() {
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        //binding.recyclerview.adapter =adapter
    }
}