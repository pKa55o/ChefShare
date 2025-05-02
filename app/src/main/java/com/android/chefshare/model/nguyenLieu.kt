package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "nguoidung")
data class nguyenLieu(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_nguyenlieu")
    @SerializedName("id_nguyenlieu")
    var idNguyenLieu: Int,

    @ColumnInfo(name = "nguyenlieu")
    @SerializedName("nguyenlieu")
    var nguyenLieu: String
)