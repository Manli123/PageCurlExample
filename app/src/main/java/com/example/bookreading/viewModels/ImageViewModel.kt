package com.example.bookreading.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookreading.R

class ImageViewModel : ViewModel() {

    private val _imageDrawables = MutableLiveData<List<Int>>()

//    val imageDrawables: LiveData<List<Int>> = _imageDrawables


    fun getImageDrawables():LiveData<List<Int>>{
        return _imageDrawables
    }

    init {
        _imageDrawables.value= listOf(
            R.drawable.page1,
            R.drawable.page2,
            R.drawable.page3,
            R.drawable.page4,
            R.drawable.page5,
            R.drawable.page6,
            R.drawable.page7,
            R.drawable.page8,
            R.drawable.page9,
            R.drawable.page10,

        )



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
}