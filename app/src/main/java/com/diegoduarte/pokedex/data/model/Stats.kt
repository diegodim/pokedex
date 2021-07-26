package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stats(
    val hp: Int? = null,
    val attack: Int? = null,
    val defense: Int? = null,
    val spAttack: Int? = null,
    val spDefense: Int? = null,
    val speed: Int? = null,
): Parcelable
