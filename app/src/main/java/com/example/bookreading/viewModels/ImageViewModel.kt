package com.example.bookreading.viewModels

import android.content.Context
import android.content.res.Configuration
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.example.bookreading.R

class ImageViewModel : ViewModel() {

    private var _imageDrawables = MutableLiveData<ArrayList<Int>>()
    private val imagesLiveData: MutableLiveData<List<Int>> = MutableLiveData()
//    val imageDrawables: LiveData<List<Int>> = _imageDrawables


    fun getImageDrawables():LiveData<ArrayList<Int>>{
        return _imageDrawables
    }

    init {
//        _imageDrawables.value= listOf(
//            R.drawable.page1,
//            R.drawable.page2,
////            R.drawable.page3,
////            R.drawable.page4,
////            R.drawable.page5,
////            R.drawable.page6,
////            R.drawable.page7,
////            R.drawable.page8,
////            R.drawable.page9,
////            R.drawable.page10,
//
//        )

            // Initialize _imageList with an empty ArrayList or with your initial data
        _imageDrawables.value = ArrayList()
        loadImages()




    }
    private fun loadImages() {
        // Simulate loading 10 image IDs into the list
        val imageIds = ArrayList<Int>()
       arrayOf(R.drawable.page1)

        imageIds.add(R.drawable.page1)
        imageIds.add(R.drawable.page2)
        imageIds.add(R.drawable.page3)
        imageIds.add(R.drawable.page4)
        imageIds.add(R.drawable.page5)
        imageIds.add(R.drawable.page6)
        imageIds.add(R.drawable.page7)
        imageIds.add(R.drawable.page8)
        imageIds.add(R.drawable.page9)
        imageIds.add(R.drawable.page10)

        _imageDrawables.value = imageIds
    }
//    val images= listOf(
//        R.drawable.page1,
//        R.drawable.page2,
//        R.drawable.page3,
//        R.drawable.page4,
//        R.drawable.page5,
//        R.drawable.page6,
//        R.drawable.page7,
//        R.drawable.page8,
//        R.drawable.page9,
//        R.drawable.page10,
//    )

    fun getImages(context: Context): LiveData<List<Int>> {
        // Fetch images here based on orientation
        val orientation = context.resources.configuration.orientation
        val images = if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getLandscapeImages()
        } else {
            getPortraitImages()
        }
        imagesLiveData.postValue(images)
        return imagesLiveData
    }

     fun getLandscapeImages(): List<Int> {
        // Fetch landscape images
        return listOf(R.drawable.page1, R.drawable.page2, R.drawable.page3)
    }

     fun getPortraitImages(): List<Int> {
        // Fetch portrait images
        return listOf(R.drawable.page4, R.drawable.page5)
    }
}

