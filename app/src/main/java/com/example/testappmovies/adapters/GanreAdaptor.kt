package com.example.testappmovies.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testappmovies.R
import com.example.testappmovies.models.Content1_Items
import com.example.testappmovies.view.DetailActivity
import kotlinx.android.synthetic.main.movie_item.view.*

class GanreAdaptor(val movies: ArrayList<Content1_Items>):RecyclerView.Adapter<GanreAdaptor.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
        return MyViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       return holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
    inner class MyViewHolder(view: View):RecyclerView.ViewHolder(view),MoviePosterAdaptor.OnClickItemInterface{
        private val ganre_title = view.ganre_title
        private val ganre_rv = view.rv_poster
        private val context = view.context

        fun bind(content1Items: Content1_Items) {
            ganre_title.text = content1Items.title_ganre
            //список фильмов
            ganre_rv.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter =
                    MoviePosterAdaptor(content1Items.content2,this@MyViewHolder)
            }
        }

        override fun OnClickItemListner(view: View?,position: Int) {
            //передача данных на detailActivity
            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("title",movies.get(adapterPosition).content2.get(position).movie_title)
            intent.putExtra("poster",movies.get(adapterPosition).content2.get(position).cover.id)
            intent.putExtra("languages",movies.get(adapterPosition).content2.get(position).languages)
            intent.putExtra("created_at",movies.get(adapterPosition).content2.get(position).created_at)
            context.startActivity(intent)
        }
    }
}

