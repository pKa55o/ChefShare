package com.android.chefshare.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.R
import com.android.chefshare.databinding.ActivityRecipeDetailBinding
import com.android.chefshare.model.Post
import com.bumptech.glide.Glide

class RecipeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = intent.getSerializableExtra("post") as? Post
        post?.let {
            binding.tvTitle.text = it.mota ?: "Không có mô tả"
            binding.tvIngredients.text = "- Đang cập nhật nguyên liệu"
            binding.tvInstructions.text = it.chidan.ifEmpty { "Chưa có hướng dẫn nấu ăn cụ thể." }

            if (!it.thumbnail.isNullOrEmpty()) {
                Glide.with(this)
                    .load(it.thumbnail)
                    .into(binding.imgRecipe)
            } else {
                binding.imgRecipe.setImageResource(R.drawable.sample_food)
            }
        }
    }
}
