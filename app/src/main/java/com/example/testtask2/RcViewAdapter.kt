package com.example.testtask2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtask2.data.remote.dto.NewsDto
import com.example.testtask2.databinding.NewsItemBinding


class RcViewAdapter(val news:NewsDto): RecyclerView.Adapter<RcViewAdapter.Holder>(){

    class Holder(item:NewsItemBinding): RecyclerView.ViewHolder(item.root){
        val title = item.title
        val description = item.description
        val author = item.author
        val content = item.content
        val time = item.time
        val icon = item.icon

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val newsItem = NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = RcViewAdapter.Holder(newsItem)
        return holder
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = news.articles[position].title
        holder.description.text = news.articles[position].description
        holder.author.text = news.articles[position].author
        holder.content.text = news.articles[position].content
        holder.time.text = news.articles[position].publishedAt
        Glide.with(holder.icon).load(news.articles[position].urlToImage).into(holder.icon)
    }

    override fun getItemCount(): Int {
        return news.articles.size
    }

}