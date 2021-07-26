package com.diegoduarte.pokedex.data.source.local.database

import androidx.room.TypeConverter
import com.diegoduarte.pokedex.data.source.local.entities.EvolutionEntity
import com.diegoduarte.pokedex.data.source.local.entities.NameEntity
import com.diegoduarte.pokedex.data.source.local.entities.ProfileEntity
import com.diegoduarte.pokedex.data.source.local.entities.StatsEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    @TypeConverter
    fun toName(string: String): NameEntity {
        val type = object : TypeToken<NameEntity>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromName(type: NameEntity): String {
        return Gson().toJson(type)
    }

    @TypeConverter
    fun toEvolution(string: String): EvolutionEntity {
        val type = object : TypeToken<EvolutionEntity>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromEvolution(type:EvolutionEntity): String {
        return Gson().toJson(type)
    }

    @TypeConverter
    fun toProfile(string: String): ProfileEntity {
        val type = object : TypeToken<ProfileEntity>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromProfile(type:ProfileEntity): String {
        return Gson().toJson(type)
    }

    @TypeConverter
    fun toStats(string: String): StatsEntity {
        val type = object : TypeToken<StatsEntity>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromStats(type: StatsEntity): String {
        return Gson().toJson(type)
    }

    @TypeConverter
    fun toListOfString(string: String): List<String> {
        val type = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromListOfString(type: List<String>): String {
        return Gson().toJson(type)
    }

    @TypeConverter
    fun toListOfListOfString(string: String): List<List<String>> {
        val type = object : TypeToken<List<List<String>>>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromListOfListOfString(type: List<List<String>>): String {
        return Gson().toJson(type)
    }


}