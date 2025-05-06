package com.android.chefshare.api

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.chefshare.R
import com.android.chefshare.api.data.dataApiService
import com.android.chefshare.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import com.android.chefshare.api.action.doAction
import com.android.chefshare.api.data.getData

class testapi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_testapi)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data = getData()
        val action = doAction()
        //run testapi.kt -> vào logcat -> gõ BBB
        /*********************GET DATA FROM API**********************/
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

/*************************************************************************************/
        val idBaiDang = 3040176
        val idNguoiDung = "HFhEieJFNRNetJysnXCEi3VEtFL2"
        val idDungcu_THAN = 3337
        val idNguyenLieu_CAROT = 4444
        val idChiDan_3040176 = 2005

        /********************INSERT DATA TO API***********************/
        /*---Tested OK---
        val baidangmoi = baiDang(null,"HFhEieJFNRNetJysnXCEi3VEtFL2",1,"Tiêu đề 2","path/to/thumbnail2.png","zxc2",5,2,"zxc2")
        action.themBaiDang(baidangmoi)

        val baiDangCachNau = baiDangCachNau(idBaiDang,1113) //1113 la XAO
        action.themBaiDangCachNau(baiDangCachNau)

        val chiDan1 = chiDan(2005,idBaiDang,1,"đây là bước 1","path/to/b1.png")
        val chiDan2 = chiDan(2006,idBaiDang,2,"đây là bước 2","path/to/b2.png")
        action.themChiDan(chiDan1)
        action.themChiDan(chiDan2)

        val baiDangChiDan = baiDangChiDan(idBaiDang,idChiDan_3040176)
        action.themBaiDangChiDan(baiDangChiDan)

        val baiDangDaThich = baiDangDaThich(idBaiDang,idNguoiDung)
        action.themBaiDangDaThich(baiDangDaThich)

        val baiDangDungCu = baiDangDungCu(idBaiDang,idDungcu_THAN)
        action.themBaiDangDungCu(baiDangDungCu)

        val baiDangNguyenLieu = baiDangNguyenLieu(idBaiDang,idNguyenLieu_CAROT)
        action.themBaiDangNguyenLieu(baiDangNguyenLieu)

        val cachNau = cachNau(null,"cách mới")
        action.themCachNau(cachNau)

        val dungCu = dungCu(null,"dụng cụ mới")
        action.themDungCu(dungCu)

        val nguyenLieu = nguyenLieu(null,"nguyên liệu mới")
        action.themNguyenLieu(nguyenLieu)

        val theoDoi = theoDoi("HFhEieJFNRNetJysnXCEi3VEtFL2","HFhEieJFNRNetJysnXCEi3VEtFL2")
        action.themTheoDoi(theoDoi)

        ===============NOTE===============
        - KHÔNG THÊM PHANLOAI (CUỘC THI,BÀI VIẾT,...)
        - KHÔNG THÊM THONGBAO
        ---------------*/
        /********************DELETE DATA TO API***********************/

        /********************UPDATE DATA TO API***********************/

/*************************************************************************************/






    }

}