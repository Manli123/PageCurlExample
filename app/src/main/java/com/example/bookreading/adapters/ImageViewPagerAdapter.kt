package com.example.bookreading.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookreading.R

class ImageViewPagerAdapter(private val images:List<Int>) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ImageViewHolder>() {


   inner class ImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val image : ImageView =itemView.findViewById(R.id.image)

   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item_layout,parent,false)
        return ImageViewHolder(view)

    }

    override fun getItemCount(): Int {
        return images.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {

        holder.image.setImageResource(images[position])



    }
}