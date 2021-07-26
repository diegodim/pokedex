package com.diegoduarte.pokedex.data.source.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.model.Evolution
import com.diegoduarte.pokedex.data.model.Name
import com.diegoduarte.pokedex.data.model.Profile
import com.diegoduarte.pokedex.data.model.Stats
import com.diegoduarte.pokedex.data.source.local.database.DataConverter

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    val id: Int? = null,
    val name: NameEntity? = null,
    val type: List<String>? = null,
    val base: StatsEntity? = null,
    val species: String? = "",
    val description: String? = "",
    val evolution: EvolutionEntity? = null,
    val profile: ProfileEntity? = null,
    val thumbnail: String? = "",
    val hires: String? = "",
    var liked: Boolean = false
)
