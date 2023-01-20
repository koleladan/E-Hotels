package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.e_hotelsapplication.Data.RestaurantModel
import com.example.e_hotelsapplication.databinding.RestaurantListBinding

class Restaurant_list_adapter (var context: Context, var restaurantlist:ArrayList<RestaurantModel>):
    RecyclerView.Adapter<Restaurant_list_adapter.RestaurantViewHolder>() {


    inner class RestaurantViewHolder(private val binding:RestaurantListBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurantModel: RestaurantModel) {
            binding.apply{
                name.text = restaurantModel.restaurant.toString()
                address.text = restaurantModel.restaurant.toString()
                hours.text = restaurantModel.hours.toString()


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