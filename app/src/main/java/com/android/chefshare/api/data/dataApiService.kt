package com.android.chefshare.api.data

import com.android.chefshare.model.*
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface dataApiService {

    @GET("baiDang.php")
    suspend fun getBaiDang(): List<baiDang>

    @GET("baiDangCachNau.php")
    suspend fun getBaiDangCachNau(): List<baiDangCachNau>

    @GET("baiDangChiDan.php")
    suspend fun getBaiDangChiDan(): List<baiDangChiDan>

    @GET("baiDangDaThich.php")
    suspend fun getBaiDangDaThich(): List<baiDangDaThich>

    @GET("baiDangDungCu.php")
    suspend fun getBaiDangDungCu(): List<baiDangDungCu>

    @GET("baiDangNguyenLieu.php")
    suspend fun getBaiDangNguyenLieu(): List<baiDangNguyenLieu>

    @GET("cachNau.php")
    suspend fun getCachNau(): List<cachNau>

    @GET("chiDan.php")
    suspend fun getChiDan(): List<chiDan>

    @GET("dungCu.php")
    suspend fun getDungCu(): List<dungCu>

    @GET("nguoiDung.php")
    suspend fun getNguoidung(): List<nguoiDung>

    @GET("nguyenLieu.php")
    suspend fun getNguyenLieu(): List<nguyenLieu>

    @GET("phanLoai.php")
    suspend fun getPhanLoai(): List<phanLoai>

    @GET("theoDoi.php")
    suspend fun getTheoDoi(): List<theoDoi>

    @GET("thongBao.php")
    suspend fun getThongBao(): List<thongBao>

}
