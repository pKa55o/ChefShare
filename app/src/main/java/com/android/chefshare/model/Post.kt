package com.android.chefshare.model

import java.io.Serializable

data class Post(
    val idBaidang: String,
    val idNguoidung: String,
    val idPhanloai: Int,
    val idCachnau: Int? = null,
    val idDungcu: Int? = null,
    val idNguyenlieu: Int? = null,
    val thumbnail: String = "",
    val mota: String = "",
    val thoigianau: Int = 0,
    val khauphan: Int = 0,
    val chidan: String = "",
    val soluongNguoithich: String = "0",
    val thoigiandang: Long? = null
) : Serializable


