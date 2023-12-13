package com.freeapp.coffeeappwithcompose.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CoffeeItem(
    @SerializedName("description")
    var description: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("image")
    var image: String,
    @SerializedName("ingredients")
    var ingredients: List<String>,
    @SerializedName("title")
    var title: String
):Parcelable