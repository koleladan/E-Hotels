package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_hotelsapplication.Data.Restaurant
import com.example.e_hotelsapplication.Data.RestaurantListData
import com.example.e_hotelsapplication.databinding.RestaurantListBinding
import kotlin.collections.ArrayList

class Restaurant_list_adapter(var context: Context, var restaurantlist: ArrayList<Restaurant>, val clickListener: RestaurantListClickListener):
    RecyclerView.Adapter<Restaurant_list_adapter.RestaurantViewHolder>() {


    inner class RestaurantViewHolder(private val binding:RestaurantListBinding):RecyclerView.ViewHolder(binding.root) {
        private val thumbImage = binding.image
        @RequiresApi(Build.VERSION_CODES.N)
        fun bind(restaurantListData: Restaurant) {
            binding.apply{
                name.text = restaurantListData.name
                address.text = "Address:" +restaurantListData.address
               // hours.text = "Today's Hours:" +getTodaysHours(restaurantListData?.hours!!)

                Glide.with(thumbImage)
                    .load(restaurantListData.image)
                    .into(thumbImage)




               // hours.text = restaurantListData.hours.toString()


            }

        }

    }
    //how to get today's hours using google calendar Api

//    @RequiresApi(Build.VERSION_CODES.N)
//    fun getTodaysHours(hours:Hours):String?{
//        val  calendar:Calendar = Calendar.getInstance()
//        val date:Date = calendar.time
//        val day:String = SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.time)
//        return when(day){
//            "Sunday" -> hours.Sunday
//            "Monday" -> hours.Monday
//            "Tuesday" -> hours.Tuesday
//            "Wednesday" -> hours.Wednesday
//            "Thursday" -> hours.Thursday
//            "Friday" -> hours.Friday
//            else -> {hours.Saturday
//
//            }
//        }
//
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RestaurantListBinding.inflate(inflater,parent, false)
        return RestaurantViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        holder.bind(restaurantlist[position])
        //setting itemview onClickListener
        holder.itemView.setOnClickListener{
            clickListener.onItemClick(restaurantlist[position])
        }
    }

    override fun getItemCount(): Int {
        return restaurantlist.size
    }
//setting the cardviews onclicklistener by having an interface and overriding it in the "RestaurantListActivity
    interface RestaurantListClickListener{
        fun onItemClick(restaurantListData: Restaurant)
    }
}

// attaching to the images url, created a package "uitel"