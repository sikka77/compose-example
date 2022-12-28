package com.plcoding.cryptocurrencyappyt.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Bhavya Sikka on 28/12/22.
 */


data class Coin(
    val id: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)