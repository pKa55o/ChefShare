package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "thongbao")
data class thongBao(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_thongbao")
    @SerializedName("id_thongbao")
    val idThongBao: Int,

    @ColumnInfo(name = "ten_thongbao")
    @SerializedName("ten_thongbao")
    val tenThongBao: String,

    @ColumnInfo(name = "noidung")
    @SerializedName("noidung")
    val noiDung: String,

    @ColumnInfo(name = "thoigian_thongbao")
    @SerializedName("thoigian_thongbao")
    val thoiGianThongbao: String
)
