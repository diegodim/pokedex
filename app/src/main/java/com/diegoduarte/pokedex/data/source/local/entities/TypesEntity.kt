package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.source.local.database.DataConverter

@Entity(tableName = "types")
@TypeConverters(DataConverter::class)
data class TypesEntity(
    @PrimaryKey
    val type: TypeEntity,
    val slot: Int
)
