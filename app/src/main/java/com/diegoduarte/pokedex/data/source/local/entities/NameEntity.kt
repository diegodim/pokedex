package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "name")
data class NameEntity(

    val english: String? = ""
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}