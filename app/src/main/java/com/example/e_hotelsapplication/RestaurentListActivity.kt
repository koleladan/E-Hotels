package com.example.e_hotelsapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_hotelsapplication.Adapters.Restaurant_list_adapter
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityRestaurentListBinding
import com.google.firebase.database.*

class RestaurentListActivity : AppCompatActivity(), Restaurant_list_adapter.RestaurantListClickListener {
    private lateinit var binding: ActivityRestaurentListBinding
    private lateinit var database:DatabaseReference
    private lateinit var adapater:Restaurant_list_adapter
    private lateinit var restaurantlist:ArrayList<RestaurantListData>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar:ActionBar?=supportActionBar
        actionbar?.setTitle( "Restaurant List")

        restaurantlist = ArrayList()
        adapater = Restaurant_list_adapter(this, restaurantlist, this)
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.adapter = adapater

        binding.imageView.setOnClickListener{
            val intent = Intent(this@RestaurentListActivity, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

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
                Log.e(ContentValues.TAG, "error")

            }

        })


    }
//passing the key "RestaurantListData" to CheckoutActivity because its parcelable
    override fun onItemClick(restaurantListData: RestaurantListData) {
        val intent = Intent(this@RestaurentListActivity,CheckoutActivity::class.java)
        intent.putExtra("RestaurantListData", restaurantListData)
        startActivity(intent)
    }


}