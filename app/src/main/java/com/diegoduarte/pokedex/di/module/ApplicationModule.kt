package com.diegoduarte.pokedex.di.module

import android.content.Context
import androidx.room.Room
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.PokedexRepositoryImpl
import com.diegoduarte.pokedex.data.source.local.LocalDataSource
import com.diegoduarte.pokedex.data.source.local.LocalDataSourceImpl
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSource
import com.diegoduarte.pokedex.data.source.remote.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton



@Module(includes = [ApplicationModuleBinds::class])
class ApplicationModule{


    @Singleton
    @Provides
    fun provideRemoteDataSource(database: PokedexDatabase):
            RemoteDataSource = RemoteDataSourceImpl(database.pokemonDao())

    @Singleton
    @Provides
    fun provideLocalDataSource(database: PokedexDatabase):
            LocalDataSource = LocalDataSourceImpl(database.pokemonDao())

    @Singleton
    @Provides
    fun provideDataBase(context: Context): PokedexDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokedexDatabase::class.java,
            "Pokedex.db"
        ).build()
    }

}

@Module
abstract class ApplicationModuleBinds{

    @Singleton
    @Binds
    abstract fun bindRepository(repo: PokedexRepositoryImpl): PokedexRepository

}