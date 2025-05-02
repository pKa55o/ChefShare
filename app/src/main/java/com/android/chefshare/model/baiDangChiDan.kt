package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang_chidan",
    foreignKeys = [
        ForeignKey(
            entity = baiDang::class,
            parentColumns = ["id_baidang"],
            childColumns = ["id_baidang"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = chiDan::class,
            parentColumns = ["id_chidan"],
            childColumns = ["id_chiDan"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_baidang"]),
        Index(value = ["id_chidan"])
    ]
)
data class baiDangChiDan(
    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int,

    @ColumnInfo(name = "id_chidan")
    @SerializedName("id_chidan")
    val idChiDan: Int
)
