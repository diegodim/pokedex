package com.diegoduarte.pokedex.data.source.local.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.diegoduarte.pokedex.data.source.local.entities.PokemonEntity

@Dao
interface PokedexDao {

    @Query("select * from pokemon")
    fun getPokemonList(): LiveData<List<PokemonEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pokemon: PokemonEntity)
}