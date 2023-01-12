package com.example.e_hotelsapplication

import android.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_hotelsapplication.databinding.ActivityPinViewBinding

class PinViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPinViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val actionBar: androidx.appcompat.app.ActionBar? =supportActionBar
        actionBar?.hide()
    }
}