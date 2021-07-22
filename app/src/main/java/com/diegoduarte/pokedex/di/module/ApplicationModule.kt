package com.diegoduarte.pokedex.di.module

import android.content.Context
import androidx.room.Room
import com.diegoduarte.pokedex.data.source.PokedexRepository
import com.diegoduarte.pokedex.data.source.PokedexRepositoryImpl
import com.diegoduarte.pokedex.data.source.local.database.PokedexDatabase
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton



@Module(includes = [ApplicationModuleBinds::class])
class ApplicationModule{


    @Singleton
    @Provides
    fun provideDataBase(context: Context): PokedexDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            PokedexDatabase::class.java,
            "Pokedex.db"
        ).build()
    }


    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

@Module
abstract class ApplicationModuleBinds{

    @Singleton
    @Binds
    abstract fun bindRepository(repo: PokedexRepositoryImpl): PokedexRepository

}