package com.android.chefshare.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "cachnau")
data class cachNau(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_cachnau", index = true)
    @SerializedName("id_cachnau")
    val idCachNau: Int?,

    @ColumnInfo(name = "cachnau")
    @SerializedName("cachnau")
    val cachNau: String
)
