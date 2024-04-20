package com.example.bookreading.Utils

import android.view.View
import androidx.viewpager2.widget.ViewPager2

class OrientationAwareTransformer : ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {
        val absPosition = Math.abs(position)
        page.scaleY = 1f - absPosition * 0.5f  // Adjust the scaling based on position
    }
}