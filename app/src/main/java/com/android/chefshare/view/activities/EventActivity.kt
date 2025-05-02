package com.android.chefshare.view.activities

import RecipeAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.chefshare.R
import com.android.chefshare.databinding.ActivityEventBinding
import com.android.chefshare.model.Post

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mockPosts = listOf(
            Post(
                idBaidang = "1",
                idNguoidung = "user_001",
                idPhanloai = 1,
                idCachnau = null,
                idDungcu = null,
                idNguyenlieu = null,
                thumbnail = "https://your-image-url.com/muc.jpg",
                mota = "Mực một nắng, muối ớt xanh",
                thoigianau = 30,
                khauphan = 2,
                chidan = "",
                soluongNguoithich = "15",
                thoigiandang = System.currentTimeMillis()
            ),
            Post(
                idBaidang = "2",
                idNguoidung = "user_002",
                idPhanloai = 2,
                thumbnail = "",
                mota = "Canh cải thìa, chả chiên",
                soluongNguoithich = "8",
                thoigiandang = null,
                idCachnau = null,
                idDungcu = null,
                idNguyenlieu = null,
                khauphan = 1,
                thoigianau = 20,
                chidan = ""
            )
        )

        binding.rvRecipes.layoutManager = LinearLayoutManager(this)
        binding.rvRecipes.adapter = RecipeAdapter(mockPosts) { post ->
            val intent = Intent(this, RecipeDetailActivity::class.java)
            intent.putExtra("post", post)
            startActivity(intent)
        }



        binding.imgBanner.setImageResource(R.drawable.banner_event)
        binding.tvEventTitle.text = "Cuộc Thi Chia Sẻ Công Thức - Tháng 5"
    }
}
