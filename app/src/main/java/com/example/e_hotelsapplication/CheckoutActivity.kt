package com.example.e_hotelsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.GridLayoutManager
import com.example.e_hotelsapplication.Adapters.menu_adapter
import com.example.e_hotelsapplication.Data.Menu
import com.example.e_hotelsapplication.Data.Restaurant
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.ActivityCheckoutBinding
import com.google.firebase.database.*
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.NonCancellable.key

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
        val restaurant = intent.getParcelableExtra<Restaurant>("RestaurantListData")


        val actionBar:ActionBar? = supportActionBar
        actionBar?.setTitle(restaurant?.name)
        actionBar?.setSubtitle(restaurant?.address)
        actionBar?.setDisplayHomeAsUpEnabled(true)

//        adapter = menu_adapter(this,menulist)
//        binding.recyclerview.adapter =adapter
        menulist= ArrayList<Menu>()
        binding.recyclerview.layoutManager = GridLayoutManager(this, 2)
        binding.recyclerview.setHasFixedSize(true)

        binding.imageView.setOnClickListener{
            val intent = Intent(this@CheckoutActivity, RestaurentListActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }


        binding.checkoutbtn.setOnClickListener {
            val intent = Intent(this@CheckoutActivity, PlaceorderActivity::class.java)
            intent.putExtra("RestaurantListData", restaurant)
            startActivity(intent)

        }
        getMenuData()
    }
//    private fun getMenuData() {
//        val menu = getRestaurantData().mapNotNull { it.menu }
//        adapter.menulist.addAll(menu.toList())
//    }
//
//    private fun getRestaurantData(): ArrayList<RestaurantListData> {
//        val restaurants = ArrayList<RestaurantListData>()
//        database = FirebaseDatabase.getInstance().getReference( "Restaurants")
//        database.addValueEventListener(object: ValueEventListener{
//            override fun onDataChange(snapshot: DataSnapshot) {
//                if (snapshot.exists()){
//                    for (restaurantListSnapshot in snapshot.children){
//                        val restaurant = restaurantListSnapshot.getValue(RestaurantListData::class.java)
//                        restaurants.add(restaurant!!)
//                        Log.d("menulist", menulist.toString())
//                    }
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//
//            }
//
//        })
//
//        return restaurants
//    }
//}

    private fun getMenuData() {
        database = FirebaseDatabase.getInstance().getReference("Restaurants")
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    snapshot.children.forEach { Log.d("snapshot", it.toString()) }
                    for (menulistSnapshot in snapshot.children) {
                        val menu = menulistSnapshot.getValue(Menu::class.java)
                        menulist.add(menu!!)


                    }
                    adapter = menu_adapter(this@CheckoutActivity, menulist)
                    binding.recyclerview.adapter = adapter
                    Log.d("menu", menulist.toString())

                }


            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("menu", "onCancelled:${error.message}")
            }
        })




    }

}

