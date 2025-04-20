package com.android.chefshare.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.chefshare.R

class DishDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dish_detail) // Liên kết với file XML
    }
}