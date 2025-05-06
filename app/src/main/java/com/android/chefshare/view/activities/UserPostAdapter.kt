package com.android.chefshare.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.chefshare.R
import com.android.chefshare.model.Post

class UserPostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<UserPostAdapter.PostViewHolder>() {

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail)
        val name: TextView = itemView.findViewById(R.id.tvDishName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.thumbnail.setImageResource(R.drawable.sample_food)
        holder.name.text = "Dau buoi"
    }

    override fun getItemCount(): Int = posts.size
}
