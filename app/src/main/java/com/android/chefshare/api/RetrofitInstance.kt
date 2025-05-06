package com.android.chefshare.api

import android.annotation.SuppressLint
import android.widget.EditText
import com.android.chefshare.api.action.actionApiService
import com.android.chefshare.api.data.dataApiService
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
//noinspection StaticFieldLeak
import retrofit2.converter.gson.GsonConverterFactory

@SuppressLint("StaticFieldLeak")
object RetrofitInstance {
    var data: EditText? = null
    val IP = "172.36.38.133" //doi ip
    val BASE_URL_DATA= "http://${IP}/api/data/"
    val BASE_URL_ACTION= "http://${IP}/api/action/"
    val TAG = "CHECK_RESPONSE"

    public val apiData = Retrofit.Builder()
        .baseUrl(BASE_URL_DATA)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(dataApiService::class.java)

    public val apiAction = Retrofit.Builder()
        .baseUrl(BASE_URL_ACTION)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .build()
        .create(actionApiService::class.java)

}