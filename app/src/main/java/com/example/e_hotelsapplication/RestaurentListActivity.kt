package com.example.e_hotelsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.example.e_hotelsapplication.databinding.ActivityRestaurentListBinding

class RestaurentListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRestaurentListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRestaurentListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionbar:ActionBar?=supportActionBar
        actionbar?.hide()
    }


}