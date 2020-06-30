package com.thiqah.newssample.presentation.view.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.thiqah.hiltsample.R
import com.thiqah.newssample.data.source.model.News
import kotlinx.android.synthetic.main.item_news.view.*
import javax.inject.Inject


class NewsAdapter @Inject constructor() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var news: List<News>? = null

    val onMovieClickListener by lazy { MutableLiveData<News>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news?.size ?: 0
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news!![position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: News) {
            itemView.tvNewsTitle.text = post.title

            itemView.setOnClickListener {
                onMovieClickListener.value = news!![adapterPosition]
            }


        }

    }


}
