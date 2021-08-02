package com.diegoduarte.pokedex.di.module

import android.content.Context
import androidx.room.Room
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.local.LocalDataSourceImpl
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSourceImpl
import com.diegoduarte.pokedex.data.source.remote.service.PokemonServiceBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideRemoteDataSource(pokemonServiceBuilder: PokemonServiceBuilder):
            RemoteDataSource = RemoteDataSourceImpl(pokemonServiceBuilder.service)

    @Singleton
    @Provides
    fun provideLocalDataSource(database: PokedexDatabase):
            LocalDataSource = LocalDataSourceImpl(database.pokemonDao())

    @Singleton
    @Provides
    fun providePokemonService(): PokemonServiceBuilder = PokemonServiceBuilder()

    @Singleton
    @Provides
    fun provideDataBase(context: Context): PokedexDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokedexDatabase::class.java,
            "Pokedex.db"
        ).fallbackToDestructiveMigration()
            .build()
    }
}