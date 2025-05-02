package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "nguoidung")
data class nguoiDung(

    @PrimaryKey
    @SerializedName("id_nguoidung")
    @ColumnInfo(name = "id_nguoidung")
    val idnguoiDung: String,

    @ColumnInfo(name = "ten_nguoidung")
    @SerializedName("ten_nguoidung")
    val tenNguoiDung: String?
)
