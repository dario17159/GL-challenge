package com.dario.carrizo.gloaballogicchallenge.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @author Dario Carrizo on 01/06/2022
 **/

typealias ProductRepsonse = ArrayList<Products>


data class Products(
    @Expose
    @SerializedName("title")
    val title: String,
    @Expose
    @SerializedName("description")
    val description: String,
    @Expose
    @SerializedName("image")
    val image: String
): Serializable
