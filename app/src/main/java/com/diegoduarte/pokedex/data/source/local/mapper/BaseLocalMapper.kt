package com.diegoduarte.pokedex.data.source.local.mapper

interface BaseLocalMapper<L, D> {

    fun toLocal(domain: D): L

    fun toDomain(local: L): D

    fun toLocal(domain: List<D>): List<L> {
        return domain.map { toLocal(it) }
    }

    fun toDomain(local: List<L>): List<D> {
        return local.map { toDomain(it) }
    }

}