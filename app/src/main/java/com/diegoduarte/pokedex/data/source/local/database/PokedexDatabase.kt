package com.diegoduarte.pokedex.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.diegoduarte.pokedex.data.source.local.entities.*

@Database(entities = [
    EvolutionEntity::class,
    NameEntity::class,
    ProfileEntity::class,
    StatsEntity::class,
    PokemonEntity::class
], version = 4, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class PokedexDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokedexDao
}