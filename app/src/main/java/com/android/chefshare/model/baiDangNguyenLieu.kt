package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang_nguyenlieu",
    foreignKeys = [
        ForeignKey(
            entity = baiDang::class,
            parentColumns = ["id_baidang"],
            childColumns = ["id_baidang"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = nguyenLieu::class,
            parentColumns = ["id_nguyenlieu"],
            childColumns = ["id_nguyenlieu"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_baidang"]),
        Index(value = ["id_nguyenlieu"])
    ]
)
data class baiDangNguyenLieu(

    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int,

    @ColumnInfo(name = "id_nguyenlieu")
    @SerializedName("id_nguyenlieu")
    val idNguyenLieu: Int
)
