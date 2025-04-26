package com.android.chefshare.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.android.chefshare.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hiện bottom navigation nếu bị ẩn
        val bottomNav = activity?.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav?.visibility = View.VISIBLE

        // Cập nhật tab đang được chọn là “home”
        bottomNav?.selectedItemId = R.id.nav_home
    }
}
//Table table {1,2,3,4,5,5,6,7,8,9}