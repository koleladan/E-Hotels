package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_hotelsapplication.Data.Menu
import com.example.e_hotelsapplication.Data.Restaurant
import com.example.e_hotelsapplication.databinding.MenuListBinding

class menu_adapter(val context: Context,val menulist: ArrayList<Menu>):RecyclerView.Adapter<menu_adapter.MenuViewHolder>() {
//    var menulist =ArrayList<Menu>()
//    set(value){
//        field =value
//        notifyDataSetChanged()
//    }



    inner  class MenuViewHolder(private val  binding: MenuListBinding):RecyclerView.ViewHolder(binding.root) {
        val foodimage = binding.fimage
        val fname = binding.foodname
        val  fprice = binding.price
        val addbutton = binding.addbtn

        fun bind(menuData: Menu){
            binding.apply {
                addbutton.setOnClickListener{
                    //menu.totalInCart = 1
                    //clickListener.addToCartClickListener(menu)
                   // addMoreLayout

                }
                fname.text = menuData.foodname
                fprice.text = "Price: $ ${menuData.price}"


                Glide.with(foodimage)
                    .load(menuData.fimage)
                    .into(foodimage)
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val binding = MenuListBinding.inflate(inflater,parent,false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menulist[position])
    }

    override fun getItemCount(): Int {
      return  menulist.size
    }
//    interface MenuListClickListener{
//        fun addToCartClickListener(menu: Menu)
//    }
}