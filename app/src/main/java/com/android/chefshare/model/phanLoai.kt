package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "phanloai")
data class phanLoai(

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id_phanloai")
    @ColumnInfo(name = "id_phanloai")
    val idPhanLoai: Int,

    @ColumnInfo(name = "phanloai")
    @SerializedName("phanloai")
    val phanLoai: String
)
