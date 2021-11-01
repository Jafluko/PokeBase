package com.example.pokebase.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pokebase.presenters.view.PokemonView
import com.example.pokebase.providers.api.RxPokeApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

@InjectViewState
class PokemonPresenter : MvpPresenter<PokemonView>() {

    private val apiClient = RxPokeApiClient()

    fun getPokemon(id: Int) {
        apiClient.getPokemon(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe {
                viewState.showData(it)
            }
    }
}