package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "baidang",
    foreignKeys = [
        ForeignKey(
            entity = nguoiDung::class,
            parentColumns = ["id_nguoidung"],
            childColumns = ["id_nguoidung"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class baiDang(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_baidang")
    @SerializedName("id_baidang")
    val idBaiDang: Int?,

    @ColumnInfo(name = "id_nguoidung", index = true)
    @SerializedName("id_nguoidung")
    val idNguoiDung: String?,

    @ColumnInfo(name = "id_phanloai")
    @SerializedName("id_phanloai")
    val idPhanLoai: Int?,

    @ColumnInfo(name = "tieude")
    @SerializedName("tieude")
    val tieuDe: String,

    @ColumnInfo(name = "thumbnail")
    @SerializedName("thumbnail")
    val thumbnail: String?,

    @ColumnInfo(name = "mota")
    @SerializedName("mota")
    val moTa: String?,

    @ColumnInfo(name = "thoigiannau")
    @SerializedName("thoigiannau")
    val thoiGianNau: Int?,

    @ColumnInfo(name = "khauphan")
    @SerializedName("khauphan")
    val khauPhan: Int?,

    @ColumnInfo(name = "thoigiandang")
    @SerializedName("thoigiandang")
    val thoiGianDang: String?
)

