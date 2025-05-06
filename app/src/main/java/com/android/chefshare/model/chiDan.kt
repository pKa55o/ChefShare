package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "chidan",
        foreignKeys = [
        ForeignKey(
        entity = baiDang::class,
        parentColumns = ["id_baidang"],
        childColumns = ["id_baidang"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )
])
data class chiDan(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_chidan")
    @SerializedName("id_chidan")
    var idchiDan: Int,

    @ColumnInfo(name = "id_baidang", index = true)
    @SerializedName("id_baidang")
    var idBaidang: Int,

    @ColumnInfo(name = "buoc")
    @SerializedName("buoc")
    var buoc: Int,

    @ColumnInfo(name = "mota")
    @SerializedName("mota")
    var moTa: String,

    @ColumnInfo(name = "anh")
    @SerializedName("anh")
    var anh: String

)