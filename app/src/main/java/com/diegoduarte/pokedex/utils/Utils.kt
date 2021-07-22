package com.diegoduarte.pokedex.utils

import java.util.*

fun toUpperCase(value: String): String {

    return value.replaceFirstChar {
        if (it.isLowerCase())
            it.titlecase(Locale.getDefault())
        else
            it.toString()
    }
}