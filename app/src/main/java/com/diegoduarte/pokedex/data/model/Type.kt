package com.diegoduarte.pokedex.data.model

import com.diegoduarte.pokedex.R

data class Type(
    val name: String
)
{
    val color: Int
    get() = when(name){
        "grass"-> R.color.green
        "bug"-> R.color.green
        "fire"-> R.color.red
        "electric"-> R.color.yellow
        "poison"-> R.color.purple
        "ground"-> R.color.brown
        "rock"->R.color.gray
        "ghost"-> R.color.purple
        "dark"-> R.color.purple
        "fairy"-> R.color.pink
        else -> R.color.blue
    }
}