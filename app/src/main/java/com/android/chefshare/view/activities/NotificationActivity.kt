package com.android.chefshare.view.activities

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.android.chefshare.MyRecipeStorageActivity
import com.android.chefshare.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotificationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        // Setup Toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            title = "Hoạt động"
            setDisplayHomeAsUpEnabled(true)
        }

        // Nút back
        toolbar.setNavigationOnClickListener {
            finish()
        }

        // Tab "Thông báo"
        val tabThongBao = findViewById<TextView>(R.id.tabThongBao)
        tabThongBao.setOnClickListener {
            tabThongBao.setTextColor(getColor(android.R.color.holo_orange_dark))
        }

        // FAB upload
        val fabAddRecipe = findViewById<FloatingActionButton>(R.id.fabAddRecipe)
        fabAddRecipe.setOnClickListener {
            val intent = Intent(this, UploadRecipeActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation
        bottomNavigation.selectedItemId = R.id.nav_storage
        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("SELECTED_TAB", R.id.nav_home)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.nav_ai -> {
                    val intent = Intent(this, AIRecipeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                R.id.nav_storage -> {
                    val intent = Intent(this, MyRecipeStorageActivity::class.java)
                    intent.putExtra("SELECTED_TAB", R.id.nav_home)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
                    startActivity(intent)
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }
}
