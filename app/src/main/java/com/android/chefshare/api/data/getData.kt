package com.android.chefshare.api.data

import android.util.Log
import android.widget.EditText
import com.android.chefshare.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/*****************CALL FUNC TO GET DATA********************/
class getData {

    var data: EditText? = null
    val IP = "172.28.144.1" //doi ip
    val BASE_URL= "http://${IP}/api/data/"
    val TAG = "CHECK_RESPONSE"

    val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)
    fun getBaiDang(){
        api.getBaiDang().enqueue(object : Callback<List<baiDang>> {
            override fun onResponse(
                call: Call<List<baiDang>>,
                response: Response<List<baiDang>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDang>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getBaiDangCachNau(){
        api.getBaiDangCachNau().enqueue(object : Callback<List<baiDangCachNau>> {
            override fun onResponse(
                call: Call<List<baiDangCachNau>>,
                response: Response<List<baiDangCachNau>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDangCachNau>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getBaiDangChiDan(){
        api.getBaiDangChiDan().enqueue(object : Callback<List<baiDangChiDan>> {
            override fun onResponse(
                call: Call<List<baiDangChiDan>>,
                response: Response<List<baiDangChiDan>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDangChiDan>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getBaiDangDaThich(){
        api.getBaiDangDaThich().enqueue(object : Callback<List<baiDangDaThich>> {
            override fun onResponse(
                call: Call<List<baiDangDaThich>>,
                response: Response<List<baiDangDaThich>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDangDaThich>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getBaiDangDungCu(){
        api.getBaiDangDungCu().enqueue(object : Callback<List<baiDangDungCu>> {
            override fun onResponse(
                call: Call<List<baiDangDungCu>>,
                response: Response<List<baiDangDungCu>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDangDungCu>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getBaiDangNguyenLieu(){
        api.getBaiDangNguyenLieu().enqueue(object : Callback<List<baiDangNguyenLieu>> {
            override fun onResponse(
                call: Call<List<baiDangNguyenLieu>>,
                response: Response<List<baiDangNguyenLieu>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<baiDangNguyenLieu>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getCachNau(){
        api.getCachNau().enqueue(object : Callback<List<cachNau>> {
            override fun onResponse(
                call: Call<List<cachNau>>,
                response: Response<List<cachNau>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<cachNau>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getChiDan(){
        api.getChiDan().enqueue(object : Callback<List<chiDan>> {
            override fun onResponse(
                call: Call<List<chiDan>>,
                response: Response<List<chiDan>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<chiDan>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getDungCu(){
        api.getDungCu().enqueue(object : Callback<List<dungCu>> {
            override fun onResponse(
                call: Call<List<dungCu>>,
                response: Response<List<dungCu>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<dungCu>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getNguoidung(){
        api.getNguoidung().enqueue(object : Callback<List<nguoiDung>> {
            override fun onResponse(
                call: Call<List<nguoiDung>>,
                response: Response<List<nguoiDung>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<nguoiDung>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getNguyenLieu(){
        api.getNguyenLieu().enqueue(object : Callback<List<nguyenLieu>> {
            override fun onResponse(
                call: Call<List<nguyenLieu>>,
                response: Response<List<nguyenLieu>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<nguyenLieu>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getPhanLoai(){
        api.getPhanLoai().enqueue(object : Callback<List<phanLoai>> {
            override fun onResponse(
                call: Call<List<phanLoai>>,
                response: Response<List<phanLoai>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<phanLoai>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getTheoDoi(){
        api.getTheoDoi().enqueue(object : Callback<List<theoDoi>> {
            override fun onResponse(
                call: Call<List<theoDoi>>,
                response: Response<List<theoDoi>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<theoDoi>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

    fun getThongBao(){
        api.getThongBao().enqueue(object : Callback<List<thongBao>> {
            override fun onResponse(
                call: Call<List<thongBao>>,
                response: Response<List<thongBao>>
            ) {
                if (response.isSuccessful) data?.setText("DATA: ${response.body()}")
                Log.d("BBB","DATA: ${response.body()}")
            }

            override fun onFailure(call: Call<List<thongBao>>, t: Throwable) {
                Log.d("BBB","FAILED : ${t.message}")

            }
        })
    }

}