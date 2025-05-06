package com.android.chefshare.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.android.chefshare.R
import com.android.chefshare.databinding.ActivityUserProfileBinding
import com.android.chefshare.model.Post
import com.android.chefshare.view.adapters.UserPostAdapter

class UserProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupUserInfo()
        setupPostGrid()
    }

    private fun setupUserInfo() {
        binding.ivAvatar.setImageResource(R.drawable.canh_ga_nuong) // ảnh mẫu
        binding.tvUsername.text = "Cỗ máy nấu ăn 2000"
        binding.tvUserId.text = "id cai db"
        binding.tvBio.text = "i cook good food"
    }

    private fun setupPostGrid() {
        val samplePosts = listOf(
            Post("1", R.drawable.suon_chay.toString(), idPhanloai = 1),
            Post("2", R.drawable.ga_nuong_mac_khen.toString(), idPhanloai = 1),
            Post("3", R.drawable.canh_ga_nuong.toString(), idPhanloai = 1),
            Post("4", R.drawable.suon_non_chay.toString(), idPhanloai = 1),
            Post("5", R.drawable.recipe_image_jpeg.toString(), idPhanloai = 1)
        )

        binding.recyclerView.adapter = UserPostAdapter(samplePosts)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
    }

}
