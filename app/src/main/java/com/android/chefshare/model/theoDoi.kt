package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "theodoi",
    foreignKeys = [
        ForeignKey(
            entity = nguoiDung::class,
            parentColumns = ["id_nguoidung"],
            childColumns = ["id_nguoidung"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = nguoiDung::class,
            parentColumns = ["id_nguoidung"],
            childColumns = ["id_nguoitheodoi"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["id_nguoidung"]),
        Index(value = ["id_nguoitheodoi"])
    ]
)
data class theoDoi(

    @ColumnInfo(name = "id_nguoidung")
    @SerializedName("id_nguoidung")
    val idNguoiDung: String,

    @ColumnInfo(name = "id_nguoitheodoi")
    @SerializedName("id_nguoitheodoi")
    val idNguoiTheoDoi: String
)
