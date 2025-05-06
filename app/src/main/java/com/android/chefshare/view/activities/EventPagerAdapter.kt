package com.android.chefshare.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.android.chefshare.R
import com.android.chefshare.model.Post
import com.bumptech.glide.Glide

class EventPagerAdapter(
    private val posts: List<Post>,
    private val onClick: (Post) -> Unit
) : RecyclerView.Adapter<EventPagerAdapter.PostViewHolder>() {

    inner class PostViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        val context = holder.view.context

        val img = holder.view.findViewById<ImageView>(R.id.imgThumbnail)
        val title = holder.view.findViewById<TextView>(R.id.tvTitle)
        val desc = holder.view.findViewById<TextView>(R.id.tvDescription)
        val likeCount = holder.view.findViewById<TextView>(R.id.tvLikeCount)
        val upvote = holder.view.findViewById<ImageButton>(R.id.btnUpvote)
        val downvote = holder.view.findViewById<ImageButton>(R.id.btnDownvote)
        val sectionBottom = holder.view.findViewById<View>(R.id.sectionBottom)

        if (post.idBaidang == "banner") {
            img.setImageResource(R.drawable.banner_event)
            sectionBottom.visibility = View.GONE
        } else {
            sectionBottom.visibility = View.VISIBLE

            // Load ảnh thumbnail
            if (post.thumbnail.startsWith("http")) {
                Glide.with(context).load(post.thumbnail).into(img)
            } else {
                val resId = context.resources.getIdentifier(
                    post.thumbnail, "drawable", context.packageName
                )
                if (resId != 0) img.setImageResource(resId)
                else img.setImageResource(R.drawable.sample_food)
            }

            title.text = post.mota
            desc.text = "Thời gian: ${post.thoigianau} phút · Khẩu phần: ${post.khauphan}"
            likeCount.text = post.soluongNguoithich

            holder.view.setOnClickListener {
                onClick(post)
            }

            upvote.setOnClickListener {
                animateVote(it)
                val current = likeCount.text.toString().toIntOrNull() ?: 0
                likeCount.text = (current + 1).toString()
            }

            downvote.setOnClickListener {
                animateVote(it)
                val current = likeCount.text.toString().toIntOrNull() ?: 0
                likeCount.text = (current - 1).coerceAtLeast(0).toString()
            }
        }
    }

    override fun getItemCount(): Int = posts.size

    private fun animateVote(view: View) {
        view.animate()
            .scaleX(0.8f)
            .scaleY(0.8f)
            .setDuration(100)
            .withEndAction {
                view.animate()
                    .scaleX(1f)
                    .scaleY(1f)
                    .setDuration(100)
                    .start()
            }
            .start()
    }
}
