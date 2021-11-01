package com.example.pokebase.providers.api

import java.util.concurrent.TimeUnit
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import okhttp3.OkHttpClient

class ClientConfig(
    val rootUrl: HttpUrl = "https://pokeapi.co/api/v2/".toHttpUrlOrNull()!!,
    val okHttpConfig: OkHttpClient.Builder.() -> OkHttpClient.Builder = {
        retryOnConnectionFailure(false)
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        writeTimeout(30, TimeUnit.SECONDS)
    }
)
