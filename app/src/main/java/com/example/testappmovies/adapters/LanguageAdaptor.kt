package com.example.testappmovies.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testappmovies.R
import com.example.testappmovies.models.LanguagesItems
import kotlinx.android.synthetic.main.language_item.view.*

class LanguageAdaptor(val languages: ArrayList<LanguagesItems>):RecyclerView.Adapter<LanguageAdaptor.MyViewHolderLang>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderLang {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.language_item,parent,false)
        return MyViewHolderLang(inflater)
    }

    override fun onBindViewHolder(holder: MyViewHolderLang, position: Int) {
        return holder.bind(languages[position])
    }

    override fun getItemCount(): Int {
        return languages.size
    }
    inner class MyViewHolderLang(view: View):RecyclerView.ViewHolder(view){
        private val lang_title = view.language_title

        fun bind(lang: LanguagesItems) {
            lang_title.text=lang.language_title
        }


    }
}

