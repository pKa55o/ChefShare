package com.android.chefshare.view.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.android.chefshare.*
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.android.chefshare.view.activities.UserProfileActivity


class MainActivity : AppCompatActivity() {

    private val popularIngredients = listOf(
        "Trứng", "Thịt bò", "Hành lá", "Tỏi", "Cà chua", "Rau thơm"
    )

    private val newIngredients = listOf(
        "Ớt chuông", "Măng tây", "Nấm đông cô", "Dưa leo", "Sả", "Khoai lang"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        // Gán thông tin user vào header Navigation Drawer
        val headerView = navigationView.getHeaderView(0)
        bindUserHeader(headerView, drawerLayout, navigationView)

        // Gán thông tin user vào header trên cùng của màn home
        bindTopHeader()

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_profile -> startActivity(Intent(this, UserProfileActivity::class.java))
                R.id.nav_notifications -> startActivity(Intent(this, NotificationActivity::class.java))
                R.id.liked -> startActivity(Intent(this, RecentDishesActivity::class.java))
                R.id.nav_challenges -> startActivity(Intent(this, EventActivity::class.java))
                R.id.nav_settings -> startActivity(Intent(this, SettingsActivity::class.java))
                R.id.nav_feedback -> startActivity(Intent(this, FeedbackActivity::class.java))
            }
            drawerLayout.closeDrawer(navigationView)
            true
        }

        // Danh sách nguyên liệu phổ biến
        val glIngredients = findViewById<GridLayout>(R.id.glIngredients)
        displayIngredientSquares(glIngredients, popularIngredients)

        // Danh sách nguyên liệu mới lên sóng
        val llRecentIngredients = findViewById<LinearLayout>(R.id.llRecentIngredients)
        displayIngredientHorizontally(llRecentIngredients, newIngredients)

        // Nút chuông
        val btnNotifications = findViewById<View>(R.id.btnNotification)
        btnNotifications.setOnClickListener {
            startActivity(Intent(this, NotificationActivity::class.java))
        }

        // Nút FAB đăng bài
        val fab = findViewById<View>(R.id.fabContainer)
        val fabAddRecipe = fab.findViewById<FloatingActionButton>(R.id.fabAddRecipe)
        fabAddRecipe.setOnClickListener {
            startActivity(Intent(this, UploadRecipeActivity::class.java))
        }

        // Click thanh tìm kiếm
        val etSearchFake = findViewById<View>(R.id.etSearchFake)
        val searchBarContainer = findViewById<View>(R.id.searchBarContainer)

        val searchIntent = Intent(this, SearchActivity::class.java)
        etSearchFake.setOnClickListener { startActivity(searchIntent) }
        searchBarContainer.setOnClickListener { startActivity(searchIntent) }

        // Nút đăng ký Premium
        val btnSubscribe = findViewById<Button>(R.id.btnSubscribe)
        btnSubscribe.setOnClickListener {
            startActivity(Intent(this, PremiumActivity::class.java))
        }

        // Bottom Navigation
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.selectedItemId = R.id.nav_home

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true

                R.id.nav_ai -> {
                    startActivity(Intent(this, UploadRecipeActivity::class.java))
                    bottomNavigation.postDelayed({
                        bottomNavigation.selectedItemId = R.id.nav_home
                    }, 200)
                    true
                }

                R.id.nav_storage -> {
                    val intent = Intent(this, MyRecipeStorageActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(intent)
                    true
                }

                else -> false
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        intent?.getIntExtra("SELECTED_TAB", R.id.nav_home)?.let { selectedTab ->
            val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
            bottomNavigation.selectedItemId = selectedTab
        }
    }

    private fun displayIngredientSquares(gridLayout: GridLayout, items: List<String>) {
        val inflater = LayoutInflater.from(this)
        gridLayout.removeAllViews()
        for (item in items) {
            val itemView = inflater.inflate(R.layout.item_ingredient_square, gridLayout, false)
            val tvName = itemView.findViewById<TextView>(R.id.tvIngredientName)
            tvName.text = item
            gridLayout.addView(itemView)
        }
    }

    private fun displayIngredientHorizontally(container: LinearLayout, items: List<String>) {
        val inflater = LayoutInflater.from(this)
        container.removeAllViews()
        for (item in items) {
            val itemView = inflater.inflate(R.layout.item_ingredient_chip, container, false)
            val tvName = itemView.findViewById<TextView>(R.id.tvIngredientName)
            tvName.text = item
            container.addView(itemView)
        }
    }

    private fun bindUserHeader(header: View, drawerLayout: DrawerLayout, navigationView: NavigationView) {
        val imgAvatar = header.findViewById<ImageView>(R.id.imgAvatar)
        val tvUsername = header.findViewById<TextView>(R.id.tvUsername)
        val tvHandle = header.findViewById<TextView>(R.id.tvHandle)

        val currentUser = FirebaseAuth.getInstance().currentUser
        val name = currentUser?.displayName
        val email = currentUser?.email
        val photoUrl = currentUser?.photoUrl?.toString()

        tvUsername.text = name ?: "Ẩn danh"
        tvHandle.text = email ?: "Không rõ"

        if (!photoUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(photoUrl)
                .placeholder(R.drawable.ic_person)
                .circleCrop()
                .into(imgAvatar)
        } else {
            imgAvatar.setImageResource(R.drawable.ic_person)
        }
    }

    private fun bindTopHeader() {
        val imgHeaderAvatar = findViewById<ImageView>(R.id.imgAvatar)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        val user = UserManager.currentUser
        val photoUrl = user?.photoUrl?.toString()

        imgHeaderAvatar.visibility = View.VISIBLE

        if (!photoUrl.isNullOrEmpty()) {
            Glide.with(this)
                .load(photoUrl)
                .placeholder(R.drawable.ic_person)
                .circleCrop()
                .into(imgHeaderAvatar)
        } else {
            imgHeaderAvatar.setImageResource(R.drawable.ic_person)
        }

        imgHeaderAvatar.setOnClickListener {
            drawerLayout.openDrawer(navigationView)
        }
    }
}
