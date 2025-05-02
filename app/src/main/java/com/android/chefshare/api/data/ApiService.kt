package com.android.chefshare.api.data

import com.android.chefshare.model.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("baiDang.php")
    fun getBaiDang(): Call<List<baiDang>>

    @GET("baiDangCachNau.php")
    fun getBaiDangCachNau(): Call<List<baiDangCachNau>>

    @GET("baiDangChiDan.php")
    fun getBaiDangChiDan(): Call<List<baiDangChiDan>>

    @GET("baiDangDaThich.php")
    fun getBaiDangDaThich(): Call<List<baiDangDaThich>>

    @GET("baiDangDungCu.php")
    fun getBaiDangDungCu(): Call<List<baiDangDungCu>>

    @GET("baiDangNguyenLieu.php")
    fun getBaiDangNguyenLieu(): Call<List<baiDangNguyenLieu>>

    @GET("cachNau.php")
    fun getCachNau(): Call<List<cachNau>>

    @GET("chiDan.php")
    fun getChiDan(): Call<List<chiDan>>

    @GET("dungCu.php")
    fun getDungCu(): Call<List<dungCu>>

    @GET("nguoiDung.php")
    fun getNguoidung(): Call<List<nguoiDung>>

    @GET("nguyenLieu.php")
    fun getNguyenLieu(): Call<List<nguyenLieu>>

    @GET("phanLoai.php")
    fun getPhanLoai(): Call<List<phanLoai>>

    @GET("theoDoi.php")
    fun getTheoDoi(): Call<List<theoDoi>>

    @GET("thongBao.php")
    fun getThongBao(): Call<List<thongBao>>

}

