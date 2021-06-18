package com.example.testappmovies.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.testappmovies.R
import com.example.testappmovies.models.Content2_Items
import kotlinx.android.synthetic.main.movie_poster.view.*

class MoviePosterAdaptor(val movies: ArrayList<Content2_Items>, val listner: OnClickItemInterface):RecyclerView.Adapter<MoviePosterAdaptor.MoviePosterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviePosterViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.movie_poster,parent,false)
        return MoviePosterViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MoviePosterViewHolder, position: Int) {
        return holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
    inner class MoviePosterViewHolder(view: View):RecyclerView.ViewHolder(view),View.OnClickListener{
        private val movie_title = view.movie_title
        private val movie_img = view.imageView
        fun bind(content2Items: Content2_Items) {
            movie_title.text = content2Items.movie_title
            movie_img.apply {
                Glide.with(itemView)
                    .load("https://www.signalmediacorp.com//b/c/${content2Items.cover.id}.jpg")
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .placeholder(R.drawable.progressanimation)
                    .error(R.drawable.ic_launcher_background)
                    .into(imageView)
            }
        }
        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if(v!=null){
            listner.OnClickItemListner(v,adapterPosition)
            }
            else{
                Log.e("Error","Null view")
            }
        }

    }
    interface OnClickItemInterface{
        fun OnClickItemListner(view: View?,position: Int)
    }
}

