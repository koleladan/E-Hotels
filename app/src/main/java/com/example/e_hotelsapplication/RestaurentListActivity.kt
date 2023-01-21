package com.example.e_hotelsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_hotelsapplication.Adapters.Restaurant_list_adapter
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityRestaurentListBinding
import com.google.firebase.database.*

class RestaurentListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurentListBinding
    private lateinit var database:DatabaseReference
    private lateinit var adapater:Restaurant_list_adapter
    private lateinit var restaurantlist:ArrayList<RestaurantListData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar:ActionBar?=supportActionBar
        actionbar?.hide()

        restaurantlist = ArrayList()
        adapater = Restaurant_list_adapter(this, restaurantlist)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapater

        getRestaurantData()
    }

    private fun getRestaurantData() {
        database = FirebaseDatabase.getInstance().getReference( "Restaurants")
        database.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (restaurantListSnapshot in snapshot.children){
                        val restaurant = restaurantListSnapshot.getValue(RestaurantListData::class.java)
                        restaurantlist.add(restaurant!!)
                    }
                    binding.recyclerview.adapter =adapater
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RestaurentListActivity, error.message,Toast.LENGTH_SHORT).show()

            }

        })


    }


}