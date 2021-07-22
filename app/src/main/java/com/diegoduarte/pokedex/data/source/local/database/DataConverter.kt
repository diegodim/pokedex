package com.diegoduarte.pokedex.data.source.local.database

import androidx.room.TypeConverter
import com.diegoduarte.pokedex.data.source.local.entities.TypeEntity
import com.diegoduarte.pokedex.data.source.local.entities.TypesEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DataConverter {

    @TypeConverter
    fun toTypeList(string: String): MutableList<TypesEntity> {
        val type = object : TypeToken<MutableList<TypesEntity>>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromTypeList(type: MutableList<TypesEntity>): String {
        return Gson().toJson(type)
    }


    @TypeConverter
    fun toType(string: String): TypeEntity {
        val type = object : TypeToken<TypeEntity>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromType(type: TypeEntity): String {
        return Gson().toJson(type)
    }

}