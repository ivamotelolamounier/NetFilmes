package com.ivamotelo.netfilmes.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movies(
    val id: Int,
    val titulo: String,
    val imagem: String?,
    val descricao: String?,
    @SerializedName("data_lancamento")
    val dataLancamento: String?
): Parcelable
