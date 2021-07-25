package com.diegoduarte.pokedex.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity
import com.diegoduarte.pokedex.data.source.local.entities.TypeEntity
import com.diegoduarte.pokedex.data.source.local.entities.TypesEntity

@Database(entities = [TypeEntity::class, TypesEntity::class, PokemonEntity::class], version = 4, exportSchema = false)
abstract class PokedexDatabase: RoomDatabase() {

    abstract fun pokemonDao(): PokedexDao
}