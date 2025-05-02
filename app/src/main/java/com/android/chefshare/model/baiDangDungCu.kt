package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang_dungcu",
    foreignKeys = [
        ForeignKey(
            entity = baiDang::class,
            parentColumns = ["id_baidang"],
            childColumns = ["id_baidang"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = dungCu::class,
            parentColumns = ["id_dungcu"],
            childColumns = ["id_dungcu"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_baidang"]),
        Index(value = ["id_dungcu"])
    ]
)
data class baiDangDungCu(

    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int,

    @ColumnInfo(name = "id_dungcu")
    @SerializedName("id_dungcu")
    val iddungcu: Int
)
