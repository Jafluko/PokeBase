package com.example.pokebase.presenters.view

import com.arellomobile.mvp.MvpView
import com.example.pokebase.models.Pokemon

interface PokemonView : MvpView {

    fun showData(pokemon: Pokemon)
}