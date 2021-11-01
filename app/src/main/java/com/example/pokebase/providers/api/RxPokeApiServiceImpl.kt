package com.example.pokebase.providers.api

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.example.pokebase.models.ApiResource
import com.example.pokebase.models.NamedApiResource
import com.example.pokebase.models.adapters.ApiResourceAdapter
import com.example.pokebase.models.adapters.NamedApiResourceAdapter
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

internal class RxPokeApiServiceImpl(
    private val config: ClientConfig
) : RxPokeApiService by Retrofit.Builder()
    .baseUrl(config.rootUrl)
    .addConverterFactory(
        GsonConverterFactory.create(
            GsonBuilder().apply {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                registerTypeAdapter(
                    TypeToken.get(ApiResource::class.java).type,
                    ApiResourceAdapter()
                )
                registerTypeAdapter(
                    TypeToken.get(NamedApiResource::class.java).type,
                    NamedApiResourceAdapter()
                )
            }.create()
        )
    )
    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
    .client(OkHttpClient.Builder().(config.okHttpConfig)().build())
    .build()
    .create(RxPokeApiService::class.java)
