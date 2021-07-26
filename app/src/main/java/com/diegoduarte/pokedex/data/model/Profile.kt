package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val height: String? = null,
    val weight: String? = null,
    val egg: List<String>? = null,
    val ability: List<List<String>>? = null,
    val gender: String? = null
): Parcelable
