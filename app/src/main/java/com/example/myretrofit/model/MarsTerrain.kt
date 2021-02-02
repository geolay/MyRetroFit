package com.example.myretrofit.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

// (POJO) Plane Old Java Objets

@Entity(tableName = "terramars_table")
data class MarsTerrain(
    val id: String,
    val price: Long,
    val type: String,
    @SerializedName("src_img")
    val srcImg: String)

