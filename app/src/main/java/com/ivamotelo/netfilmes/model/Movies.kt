package com.ivamotelo.netfilmes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Movies(
    val id: Int,
    val title: String,
    val image: String?,
    val description: String?,
    @SerializedName("launch_date")
    val launchDate: String?
): Parcelable
