package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang_dathich",
    foreignKeys = [
        ForeignKey(
            entity = baiDang::class,
            parentColumns = ["id_baidang"],
            childColumns = ["id_baidang"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = nguoiDung::class,
            parentColumns = ["id_nguoidung"],
            childColumns = ["id_nguoidung"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_baidang"]),
        Index(value = ["id_nguoidung"])
    ]
)
data class baiDangDaThich(

    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int,

    @ColumnInfo(name = "id_nguoidung")
    @SerializedName("id_nguoidung")
    val idDaThich: String
)
