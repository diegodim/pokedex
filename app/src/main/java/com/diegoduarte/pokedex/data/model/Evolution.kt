package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Evolution(
    val prev: List<String>? = null,
    val next: List<List<String>>? = null,
): Parcelable
