package com.example.bookreading.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.bookreading.R
import com.example.bookreading.adapters.ImageViewPagerAdapter
import com.example.bookreading.databinding.ActivityMainBinding
import com.example.bookreading.viewModels.ImageViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    private lateinit var viewModel : ImageViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

//        val adapter = ImageViewPagerAdapter(viewModel.images)

//        binding.viewPager.adapter = adapter

        // Observe changes in ViewModel's LiveData
        viewModel.getImageDrawables().observe(this, Observer {
            val adapter=ImageViewPagerAdapter(it)
            binding.viewPager.adapter=adapter
        })


    }
}