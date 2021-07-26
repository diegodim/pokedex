package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Name (
    val english: String
): Parcelable