package com.sanskar.searchappkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sanskar.searchappkotlin.model.Item
import kotlinx.android.synthetic.main.activity_main.view.*


class MyAdapter() : RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<Item> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_list, parent, false)
        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = items[position]
        holder.language.text = currentItem.language
        holder.userName.text = currentItem.name
        holder.userRating.text = currentItem.stargazersCount.toString()
        Glide.with(holder.itemView.context).load(currentItem.avatarUrl).into(holder.userAvatar)
    }

    fun updateSearch(updatedSearch: ArrayList<Item>) {
        items.clear()
        items.addAll(updatedSearch)

        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size

    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val language: TextView = itemView.findViewById(R.id.language)
    val userAvatar: ImageView = itemView.findViewById(R.id.profile_pic)
    val userName: TextView = itemView.findViewById(R.id.name)
    val userRating: TextView = itemView.findViewById(R.id.star)


}
