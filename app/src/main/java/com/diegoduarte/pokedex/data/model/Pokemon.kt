package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val id: Int,
    val height: Int,
    val weight: Int,
    val baseExperience: Int,
    val types: List<Types>,
    var liked: Boolean = false
): Parcelable{

    val floatHeight: Float
    get() = (height/10f)

    val floatWeight: Float
        get() = (weight/10f)

}
