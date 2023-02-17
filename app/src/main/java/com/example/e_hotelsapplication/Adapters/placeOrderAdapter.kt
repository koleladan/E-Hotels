package com.example.e_hotelsapplication.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.e_hotelsapplication.databinding.OrderListBinding

class placeOrderAdapter(val context: Context,val menulist:ArrayList<Menu>):RecyclerView.Adapter<placeOrderAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: OrderListBinding):RecyclerView.ViewHolder(binding.root) {

        val fimage = binding.fimage
        val  fname = binding.foodname
        val fprice = binding.price
        val quantity = binding.quantity
        fun bind(menu: Menu) {
            binding.apply {
                //fname.text = menu.foodname
                //fprice.text = "Price: $ ${menu.price}"

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=OrderListBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder:placeOrderAdapter.ViewHolder, position: Int) {

        holder.bind(menulist[position])
    }

    override fun getItemCount(): Int {
        return menulist.size
    }
}