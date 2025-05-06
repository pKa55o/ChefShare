package com.android.chefshare.view.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.R
import com.android.chefshare.databinding.ActivityEventBinding
import com.android.chefshare.model.Post
import com.android.chefshare.view.adapters.EventPagerAdapter

class EventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Danh sách bài viết demo - bài đầu tiên là banner
        val posts = listOf(
            Post(
                idBaidang = "banner", // ID đặc biệt để hiển thị banner toàn màn hình
                mota = "BANNER" // dùng để adapter biết đây là banner
            ),
            Post(
                idBaidang = "2",
                idNguoidung = "user_002",
                idPhanloai = 2,
                thumbnailRes = R.drawable.sample_food,
                mota = "Canh cải thìa, chả chiên",
                thoigianau = 20,
                khauphan = 1,
                soluongNguoithich = "8"
            )
            ,
            Post(
                idBaidang = "2",
                idNguoidung = "user_002",
                idPhanloai = 2,
                thumbnailRes = R.drawable.sample_food,
                mota = "Canh cải thìa, chả chiên",
                thoigianau = 20,
                khauphan = 1,
                soluongNguoithich = "8"
            )
        )

        // Gán adapter dọc cho ViewPager2
        val adapter = EventPagerAdapter(posts) { post ->
            if (post.idBaidang != "banner") {
                val intent = Intent(this, DishDetailActivity::class.java)
                intent.putExtra("post", post) // nếu cần truyền dữ liệu
                startActivity(intent)
            }
        }


        binding.viewPagerEvent.adapter = adapter
        binding.viewPagerEvent.orientation = androidx.viewpager2.widget.ViewPager2.ORIENTATION_VERTICAL
    }
}
