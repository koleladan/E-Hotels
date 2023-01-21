package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.RestaurantListBinding

class Restaurant_list_adapter (var context: Context, var restaurantlist:ArrayList<RestaurantListData>):
    RecyclerView.Adapter<Restaurant_list_adapter.RestaurantViewHolder>() {


    inner class RestaurantViewHolder(private val binding:RestaurantListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantListData: RestaurantListData) {
            binding.apply{
                name.text = restaurantListData.name
                address.text = restaurantListData.address
               // hours.text = restaurantListData.hours.toString()


            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RestaurantListBinding.inflate(inflater,parent, false)
        return RestaurantViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurantlist[position])
    }

    override fun getItemCount(): Int {
        return restaurantlist.size
    }
}

// attaching to the images url, created a package "uitel"