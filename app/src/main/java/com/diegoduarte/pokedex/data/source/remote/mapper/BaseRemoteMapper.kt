package com.diegoduarte.pokedex.data.source.remote.mapper

interface  BaseRemoteMapper<in R, out D> {

    fun toDomain(remote: R): D

    fun toDomain(remote: List<R>): List<D> {
        return remote.map { toDomain(it) }
    }
}