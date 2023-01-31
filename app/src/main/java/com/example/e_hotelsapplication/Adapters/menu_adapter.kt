package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.e_hotelsapplication.Data.Menu
import com.example.e_hotelsapplication.databinding.MenuListBinding

class menu_adapter(val context: Context, val menulist:ArrayList<Menu>):RecyclerView.Adapter<menu_adapter.MenuViewHolder>() {



    inner  class MenuViewHolder(private val  binding: MenuListBinding):RecyclerView.ViewHolder(binding.root) {
        val foodimage = binding.fimage

        fun bind(bind:Menu){
            binding.apply {
                foodname.text = bind.foodname
                price.text = "Price:" +bind.price


                Glide.with(foodimage)
                    .load(bind.fimage)
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
      return if(menulist==null) return  0 else menulist.size
    }
}