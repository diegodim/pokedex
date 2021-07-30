package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.source.local.database.DataConverter

@Entity(tableName = "evolution")
data class EvolutionEntity(

    val prev: List<String>? = null,
    val next: List<List<String>>? = null
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
