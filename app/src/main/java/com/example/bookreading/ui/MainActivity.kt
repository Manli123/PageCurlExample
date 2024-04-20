package com.example.bookreading.ui

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.bookreading.R
import com.example.bookreading.Utils.OrientationAwareTransformer
import com.example.bookreading.adapters.ImageViewPagerAdapter
import com.example.bookreading.databinding.ActivityMainBinding
import com.example.bookreading.viewModels.ImageViewModel


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ImageViewModel
    private lateinit var adapter: ImageViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ImageViewModel::class.java)

//        val adapter = ImageViewPagerAdapter(viewModel.images)

//        binding.viewPager.adapter = adapter


        adapter = ImageViewPagerAdapter(emptyList(),this)
        binding.viewPager.adapter = adapter
//
        viewModel.getImageDrawables().observe(this, Observer { imageIds ->
            adapter = ImageViewPagerAdapter(imageIds,this)
            binding.viewPager.adapter = adapter

        })
//        // Observe screen orientation changes
//        this.resources.configuration.orientation.also { orientation ->
//            if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
//
//            } else {
//
//            }
//        }
//    }

        // Set custom ViewPager2 transformer



        binding.pageCurView.setCurlView(viewModel.getImageDrawables().value)
        binding.pageCurView.SetCurlMode(1)

        binding.pageCurView.setCurlSpeed(600)



    }
}