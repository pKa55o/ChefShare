package com.android.chefshare.api.action

//import android.telecom.Call
import com.android.chefshare.model.*
import com.google.gson.JsonObject

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface actionApiService {

/*----------------------------THEM---------------------------*/

    @POST("themBaiDang.php")
    suspend fun themBaiDang(
        @Body baidang: JsonObject
    ): Response<ApiResponseAction>

    @POST("themBaiDangCachNau.php")
    suspend fun themBaiDangCachNau(
        @Body baiDangCachNau: JsonObject
    ): Response<ApiResponseAction>

    @POST("themBaiDangChiDan.php")
    suspend fun themBaiDangChiDan(
        @Body baidangchidan: JsonObject
    ): Response<ApiResponseAction>

    @POST("themBaiDangDaThich.php")
    suspend fun themBaiDangDaThich(
        @Body baidangdathich: JsonObject
    ): Response<ApiResponseAction>

    @POST("themBaiDangDungCu.php")
    suspend fun themBaiDangDungCu(
        @Body baidangdungcu: JsonObject
    ): Response<ApiResponseAction>

    @POST("themBaiDangNguyenLieu.php")
    suspend fun themBaiDangNguyenLieu(
        @Body baidangnguyenlieu: JsonObject
    ): Response<ApiResponseAction>

    @POST("themCachNau.php")
    suspend fun themCachNau(
        @Body cachnau: JsonObject
    ): Response<ApiResponseAction>

    @POST("themChiDan.php")
    suspend fun themChiDan(
        @Body chidan: JsonObject
    ): Response<ApiResponseAction>

    @POST("themDungCu.php")
    suspend fun themDungCu(
        @Body dungcu: JsonObject
    ): Response<ApiResponseAction>

    @POST("themNguyenLieu.php")
    suspend fun themNguyenLieu(
        @Body nguyenlieu: JsonObject
    ): Response<ApiResponseAction>

    @POST("themTheoDoi.php")
    suspend fun themTheoDoi(
        @Body theodoi: JsonObject
    ): Response<ApiResponseAction>

/*----------------------------XOA---------------------------*/

    @POST("xoaBaiDang.php")
    suspend fun xoaBaiDang(
        @Body baidang: Int
    ): Response<ApiResponseAction>

    @POST("xoaTheoDoi.php")
    suspend fun xoaTheoDoi(
        @Body theodoi: String
    ): Response<ApiResponseAction>

//    @POST("xoaChiDan.php")
//    suspend fun xoaChiDan(
//        @Body chidan: Int
//    ): Response<ApiResponseAction>
//
//    @POST("xoaDungCu.php")
//    suspend fun xoaDungCu(
//        @Body dungcu: JsonObject
//    ): Response<ApiResponseAction>
//
//    @POST("xoaNguyenLieu.php")
//    suspend fun xoaNguyenLieu(
//        @Body nguyenlieu: JsonObject
//    ): Response<ApiResponseAction>


/*----------------------------SUA---------------------------*/

    @POST("capnhatBaiDang.php")
    suspend fun capnhatBaiDang(
        @Body baidang: JsonObject
    ): Response<ApiResponseAction>

    @POST("capnhatBaiDangCachNau.php")
    suspend fun capnhatBaiDangCachNau(
        @Body baiDangCachNau: JsonObject
    ): Response<ApiResponseAction>

    @POST("capnhatBaiDangChiDan.php")
    suspend fun capnhatBaiDangChiDan(
        @Body baidangchidan: JsonObject
    ): Response<ApiResponseAction>

    @POST("capnhatBaiDangDaThich.php")
    suspend fun capnhatBaiDangDaThich(
        @Body baidangdathich: JsonObject
    ): Response<ApiResponseAction>

    @POST("capnhatBaiDangDungCu.php")
    suspend fun capnhatBaiDangDungCu(
        @Body baidangdungcu: JsonObject
    ): Response<ApiResponseAction>

    @POST("capnhatBaiDangNguyenLieu.php")
    suspend fun capnhatBaiDangNguyenLieu(
        @Body baidangnguyenlieu: JsonObject
    ): Response<ApiResponseAction>


    @POST("capnhatChiDan.php")
    suspend fun capnhatChiDan(
        @Body chidan: JsonObject
    ): Response<ApiResponseAction>

//    @POST("capnhatCachNau.php")
//    suspend fun capnhatCachNau(
//        @Body cachnau: JsonObject
//    ): Response<ApiResponseAction>
//
//    @POST("capnhatDungCu.php")
//    suspend fun capnhatDungCu(
//        @Body dungcu: JsonObject
//    ): Response<ApiResponseAction>
//
//    @POST("capnhatNguyenLieu.php")
//    suspend fun capnhatNguyenLieu(
//        @Body nguyenlieu: JsonObject
//    ): Response<ApiResponseAction>
//
//    @POST("capnhatTheoDoi.php")
//    suspend fun capnhatTheoDoi(
//        @Body theodoi: JsonObject
//    ): Response<ApiResponseAction>

}