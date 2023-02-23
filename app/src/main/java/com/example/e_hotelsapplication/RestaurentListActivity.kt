package com.example.e_hotelsapplication

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.e_hotelsapplication.Adapters.Restaurant_list_adapter
import com.example.e_hotelsapplication.Data.Menu
import com.example.e_hotelsapplication.Data.Restaurant
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityRestaurentListBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue

class RestaurentListActivity : AppCompatActivity(), Restaurant_list_adapter.RestaurantListClickListener {
    private lateinit var binding: ActivityRestaurentListBinding
    private lateinit var database:DatabaseReference
    private lateinit var adapater:Restaurant_list_adapter
    private lateinit var restaurantlist:ArrayList<Restaurant>
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

        binding.navimage.setOnClickListener{
            binding.drawerlayout.openDrawer(GravityCompat.START)
        }
        binding.nav.setNavigationItemSelectedListener { item ->
            Log.i(ContentValues.TAG, "onNavigationItemSelected:" + item.itemId)
            when (item.itemId) {
                R.id.about -> {
                    Toast.makeText(applicationContext, "clicked", Toast.LENGTH_SHORT).show()

                }
                R.id.settings -> {

                }
                R.id.share -> {

                }
                R.id.contact -> {

                }

            }
            binding.drawerlayout.closeDrawer(GravityCompat.START)
            Log.i(ContentValues.TAG, "onNavigationItemSelected:nothing clicked")
            false
        }

        getRestaurantData()
    }

    private fun getRestaurantData() {
        database = FirebaseDatabase.getInstance().getReference( "Restaurants")
        database.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    snapshot.children.forEach { Log.d("snapshot", it.toString()) }

                    }
                    for (restaurantListSnapshot in snapshot.children){
                        val restaurant = restaurantListSnapshot.getValue(Restaurant::class.java)
                        restaurantlist.add(restaurant!!)
                    }
                    binding.recyclerview.adapter =adapater
                }




            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@RestaurentListActivity, error.message,Toast.LENGTH_SHORT).show()
                Log.e(ContentValues.TAG, "error")

            }

        })


    }
//passing the key "RestaurantListData" to CheckoutActivity because its parcelable
    override fun onItemClick(restaurantlist: Restaurant) {
        val intent = Intent(this@RestaurentListActivity,CheckoutActivity::class.java)
        intent.putExtra("RestaurantListData", restaurantlist)
        startActivity(intent)
    }


}