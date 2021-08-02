package com.diegoduarte.pokedex.data.source.remote.service

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class PokemonServiceBuilder {
    private val BASE_URL = "https://app.pokemon-api.xyz/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(provideOkHttpClient())
        .baseUrl(BASE_URL)
        .build()

    private fun provideOkHttpClient(): OkHttpClient {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC

        return OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .addNetworkInterceptor(interceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()
    }

    val service: PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }


}