package com.android.chefshare.model

data class Post (
    val idBaidang: String,
    val idNguoidung: String?,
    val idPhanloai: Int?,
    val idCachnau: String?,
    val idDungcu: String?,
    val idNguyenlieu: String?,
    val thumbnail: String?,
    val mota: String?,
    val thoigianau: Int?,
    val khauphan: Int?,
    val chidan: String?,
    val soluongNguoithich: String?,
    val thoigiandang: Long?
)