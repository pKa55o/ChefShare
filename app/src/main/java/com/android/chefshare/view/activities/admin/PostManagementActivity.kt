package com.android.chefshare.view.activities.admin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.android.chefshare.R

class PostManagementActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_management)

        val btnViewDetail = findViewById<Button>(R.id.btnViewPostDetail)
        btnViewDetail.setOnClickListener {
            startActivity(Intent(this, PostDetailActivity::class.java))
        }

        val btnBack = findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Quay lại màn hình trước
        }
    }
}
