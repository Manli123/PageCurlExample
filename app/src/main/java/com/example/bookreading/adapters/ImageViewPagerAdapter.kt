package com.example.bookreading.adapters

import android.content.Context
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import app.num.numandroidpagecurleffect.PageCurlView
import com.bumptech.glide.Glide
import com.example.bookreading.R

class ImageViewPagerAdapter(private val images:List<Int>,private val context: Context) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ImageViewHolder>() {
    var imageCount : Int = 0


    inner class ImageViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val imageView : ImageView =itemView.findViewById(R.id.pagesImg)
        val circle1 : View =itemView.findViewById(R.id.circle1)
        val circle2 : View =itemView.findViewById(R.id.circle2)
        val rootLayout : ConstraintLayout =itemView.findViewById(R.id.rootLayout)


   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item_layout,parent,false)
        return ImageViewHolder(view)

    }

    override fun getItemCount(): Int {
        return images.size

    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {


        holder.imageView.setImageResource(images[position])

        var right_to_left_anim=
            AnimationUtils.loadAnimation(context,R.anim.right_to_left).apply {
            duration=700
            interpolator= AccelerateDecelerateInterpolator()
        }

        var left_to_right_anim=
            AnimationUtils.loadAnimation(context,R.anim.left_to_right).apply {
            duration=700
            interpolator= AccelerateDecelerateInterpolator()
        }


        holder.imageView.setOnTouchListener(object : View.OnTouchListener {
            private val SWIPE_THRESHOLD = 100
            private var downX = 0f
            private var upX = 0f

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        downX = event.x
                        return true
                    }

                    MotionEvent.ACTION_UP -> {
                        upX = event.x
                        val deltaX = downX - upX
                        if (deltaX > SWIPE_THRESHOLD) {
                            // Swipe from right to left detected
                            right_to_left_anim.setAnimationListener(object :
                                Animation.AnimationListener {
                                override fun onAnimationStart(animation: Animation) {
                                    var handler = Handler()
                                    handler.postDelayed({
                                        if(imageCount==images.size-1){
                                            imageCount=-1
                                        }
                                        imageCount++
                                        holder.imageView.setImageResource(images[imageCount])
                                    },100)
                                }

                                override fun onAnimationEnd(p0: Animation?) {
                                }

                                override fun onAnimationRepeat(p0: Animation?) {
                                }

                            })
                            holder.circle2.startAnimation(right_to_left_anim)
                        }
                        else if(-deltaX > SWIPE_THRESHOLD){
                            left_to_right_anim.setAnimationListener(object : Animation.AnimationListener{
                                override fun onAnimationStart(p0: Animation?) {
                                    var handler= Handler()
                                    handler.postDelayed({
                                        if(imageCount==0){
                                            imageCount=images.size
                                        }
                                        imageCount--
                                        holder.imageView.setImageResource(images[imageCount])
                                    },100)
                                }

                                override fun onAnimationEnd(p0: Animation?) {
                                }

                                override fun onAnimationRepeat(p0: Animation?) {
                                }

                            })
                            holder.circle1.startAnimation(left_to_right_anim)
                        }
                        return true
                    }
                }
                return false
            }

        })
        holder.rootLayout.setOnTouchListener(object : View.OnTouchListener {
            private val SWIPE_THRESHOLD = 100
            private var downX = 0f
            private var upX = 0f

            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        downX = event.x
                        return true
                    }

                    MotionEvent.ACTION_UP -> {
                        upX = event.x
                        val deltaX = downX - upX
                        if (deltaX > SWIPE_THRESHOLD) {
                            // Swipe from right to left detected
                            right_to_left_anim.setAnimationListener(object :
                                Animation.AnimationListener {
                                override fun onAnimationStart(animation: Animation) {
                                    var handler = Handler()
                                    handler.postDelayed({
                                        if(imageCount==images.size-1){
                                            imageCount=-1
                                        }
                                        imageCount++
                                        holder.imageView.setImageResource(images[imageCount])
                                    },100)
                                }

                                override fun onAnimationEnd(p0: Animation?) {
                                }

                                override fun onAnimationRepeat(p0: Animation?) {
                                }

                            })
                            holder.circle2.startAnimation(right_to_left_anim)
                        }
                        else if(-deltaX > SWIPE_THRESHOLD){
                            left_to_right_anim.setAnimationListener(object : Animation.AnimationListener{
                                override fun onAnimationStart(p0: Animation?) {
                                    var handler= Handler()
                                    handler.postDelayed({
                                        if(imageCount==0){
                                            imageCount=images.size
                                        }
                                        imageCount--
                                        holder.imageView.setImageResource(images[imageCount])
                                    },100)
                                }

                                override fun onAnimationEnd(p0: Animation?) {
                                }

                                override fun onAnimationRepeat(p0: Animation?) {
                                }

                            })
                            holder.circle1.startAnimation(left_to_right_anim)
                        }
                        return true
                    }
                }
                return false
            }

        })

//        holder.pageCurlView.setCurlView(images)
//        holder.pageCurlView.setCurlSpeed(800)

//        Log.e("images",""+images.get(position))





    }
}