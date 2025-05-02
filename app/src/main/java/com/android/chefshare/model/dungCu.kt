package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dungcu")
data class dungCu(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_dungcu")
    @SerializedName("id_dungcu")
    val idDungCu: Int,

    @ColumnInfo(name = "dungcu")
    @SerializedName("dungcu")
    val dungCu: String?
)
