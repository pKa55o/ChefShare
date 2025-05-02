package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang_cachnau",
    foreignKeys = [
        ForeignKey(
            entity = baiDang::class,
            parentColumns = ["id_baidang"],
            childColumns = ["id_baidang"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = cachNau::class,
            parentColumns = ["id_cachnau"],
            childColumns = ["id_cachnau"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_baidang"]),
        Index(value = ["id_cachnau"])
    ]
)
data class baiDangCachNau(

    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int,

    @ColumnInfo(name = "id_cachnau")
    @SerializedName("id_cachnau")
    val idCachNau: Int
)
