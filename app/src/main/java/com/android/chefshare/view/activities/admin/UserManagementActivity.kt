package com.android.chefshare.view.activities.admin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.android.chefshare.R

class UserManagementActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_management)

        val btnViewPosts = findViewById<Button>(R.id.btnViewUserPosts)
        btnViewPosts.setOnClickListener {
            val intent = Intent(this, PostManagementActivity::class.java)
            startActivity(intent)
        }

    }
}
