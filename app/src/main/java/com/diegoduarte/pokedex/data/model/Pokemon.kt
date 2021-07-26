package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import com.diegoduarte.pokedex.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val id: Int? = null,
    val name: Name? = null,
    val type: List<String>? = null,
    val base: Stats? = null,
    val species: String? = "",
    val description: String? = "",
    val evolution: Evolution? = null,
    val profile: Profile? = null,
    val thumbnail: String? = "",
    val hires: String? = "",
    var liked: Boolean = false
): Parcelable {
    val color: Int
        get() = when(type?.get(0)){
            "Grass"-> R.color.green
            "Bug"-> R.color.green
            "Fire"-> R.color.red
            "Electric"-> R.color.yellow
            "Poison"-> R.color.purple
            "Ground"-> R.color.brown
            "Rock"-> R.color.brown
            "Ghost"-> R.color.purple
            "Dark"-> R.color.purple
            "Fairy"-> R.color.pink
            else -> R.color.blue
        }
}