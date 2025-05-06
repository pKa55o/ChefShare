package com.android.chefshare.view.activities

import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.databinding.ActivityRecipeDetailBinding
import com.android.chefshare.model.Post
import com.bumptech.glide.Glide
// xu ly event
class RecipeDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecipeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận post được gửi từ EventActivity
        val post = intent.getSerializableExtra("post") as? Post

        post?.let {
            // Hiển thị mô tả, thời gian, khẩu phần
            binding.tvTitle.text = it.mota
            binding.tvTimePortion.text = "⏱ ${it.thoigianau} phút | 👨‍👩‍👧‍👦 ${it.khauphan} người"

            // Load ảnh bằng Glide
            Glide.with(this)
                .load(it.thumbnail)
                .placeholder(com.android.chefshare.R.drawable.sample_food)
                .into(binding.imgRecipe)

            // Nguyên liệu
            val ingredients = listOf(
                "1 con cá dìa 600g",
                "1 miếng thơm",
                "1 quả cà chua",
                "Măng chua",
                "1 cây dọc mùng",
                "5 quả đậu bắp",
                "3 quả ớt xanh",
                "1 thìa me chín",
                "5 củ hành tím",
                "Hành, ngò, rau ngổ",
                "Gia vị: 1 thìa hạt nêm",
                "1 thìa muối sống"
            )

            // Cách làm
            val steps = listOf(
                "Cá dìa làm ruột, rửa sạch, con to nên mình cắt đôi.",
                "Sơ chế sạch sẽ nguyên liệu nấu canh chua.",
                "Ngâm me với 2 chén nước sôi cho ra nước chua, vào rây lọc lấy nước, bỏ xác.",
                "Tao 1 thìa dầu với hành tím, măng chua, cho nước cốt me và nước vừa đủ đun sôi, tiếp theo đến cá dìa, thơm, nêm gia vị vừa ăn, tiếp tục cho dọc mùng và đậu bắp vào.",
                "Sau cùng xắt nhỏ rau và cho vào nồi canh. Ăn kèm nước mắm ớt nguyên chất."
            )

            // Hiển thị nguyên liệu từng dòng
            ingredients.forEach { ingredient ->
                val tv = TextView(this).apply {
                    text = "• $ingredient"
                    setTextColor(Color.WHITE)
                    textSize = 16f
                    setPadding(0, 4, 0, 4)
                }
                binding.ingredientsContainer.addView(tv)
            }

            // Hiển thị các bước nấu ăn có đánh số
            steps.forEachIndexed { index, step ->
                val tv = TextView(this).apply {
                    text = "${index + 1}. $step"
                    setTextColor(Color.LTGRAY)
                    textSize = 16f
                    setPadding(0, 8, 0, 8)
                }
                binding.stepsContainer.addView(tv)
            }
        }
    }
}
