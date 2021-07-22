package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.source.local.database.DataConverter

@Entity(tableName = "pokemon")
@TypeConverters(DataConverter::class)
data class PokemonEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val types: MutableList<TypesEntity>
)
