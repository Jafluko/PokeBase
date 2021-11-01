package com.example.pokebase.providers.api

class ErrorResponse(val code: Int, message: String) : Throwable("($code) $message")
