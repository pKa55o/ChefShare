package com.android.chefshare.view.activities

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.R

class FeedbackActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)

        val backButton = findViewById<ImageButton>(R.id.btnBack_recipe)

        backButton.setOnClickListener {
            finish()
        }
    }

}