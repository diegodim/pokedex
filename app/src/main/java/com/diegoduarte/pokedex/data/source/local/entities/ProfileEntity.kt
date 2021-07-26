package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.source.local.database.DataConverter

@Entity(tableName = "profile")
data class ProfileEntity(
    val height: String? = null,
    val weight: String? = null,
    val egg: List<String>? = null,
    val ability: List<List<String>>? = null,
    val gender: String? = null
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
