package com.android.chefshare.api

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.chefshare.R
import com.android.chefshare.api.data.ApiService
import com.android.chefshare.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.android.chefshare.api.*
import com.android.chefshare.api.data.getData

class testapi : AppCompatActivity() {
    var data: EditText? = null
//    val IP = "192.168.68.62" //doi ip
//    val BASE_URL= "http://${IP}/api/data/"
//    val TAG = "CHECK_RESPONSE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testapi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         data = findViewById<EditText>(R.id.data)
        val data = getData()
        data.getThongBao()
        data.getNguyenLieu()
        data.getNguoidung()
        data.getChiDan()
        data.getBaiDang()
        data.getBaiDangCachNau()
        data.getBaiDangChiDan()
        data.getBaiDangDaThich()
        data.getBaiDangDungCu()
        data.getBaiDangNguyenLieu()
        data.getCachNau()
        data.getChiDan()
        data.getNguoidung()
        data.getPhanLoai()
        data.getTheoDoi()
        //run testapi.kt -> vào logcat -> gõ BBB
    }

}