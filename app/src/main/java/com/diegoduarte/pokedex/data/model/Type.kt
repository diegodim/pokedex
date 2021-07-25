package com.diegoduarte.pokedex.data.model

import android.os.Parcelable
import com.diegoduarte.pokedex.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Type(
    val name: String
): Parcelable
{
    val color: Int
    get() = when(name){
        "grass"-> R.color.green
        "bug"-> R.color.green
        "fire"-> R.color.red
        "electric"-> R.color.yellow
        "poison"-> R.color.purple
        "ground"-> R.color.brown
        "rock"-> R.color.brown
        "ghost"-> R.color.purple
        "dark"-> R.color.purple
        "fairy"-> R.color.pink
        else -> R.color.blue
    }
}