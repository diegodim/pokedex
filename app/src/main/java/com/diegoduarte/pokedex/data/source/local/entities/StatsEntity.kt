package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stats")
data class StatsEntity (
    val hp: Int? = null,
    val attack: Int? = null,
    val defense: Int? = null,
    val spAttack: Int? = null,
    val spDefense: Int? = null,
    val speed: Int? = null
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}