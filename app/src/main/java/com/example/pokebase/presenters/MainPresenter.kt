package com.example.pokebase.presenters

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pokebase.models.NamedApiResource
import com.example.pokebase.models.Pokemon
import com.example.pokebase.models.adapters.PokeAdapter
import com.example.pokebase.presenters.view.MainView
import com.example.pokebase.providers.api.RxPokeApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.internal.wait

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    private val apiClient = RxPokeApiClient()
    private var pokeTemp: MutableList<NamedApiResource> = mutableListOf()

    // start value
    private var offset = 1
    private var limit = 30

    fun getList(): List<NamedApiResource> = pokeTemp

    fun getPokemons() {
        apiClient.getPokemonList(offset, limit)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe {
                getDetailsAboutPokemons(it.results)
                pokeTemp.addAll(it.results)
                viewState.showList()
                viewState.updateAdapter(pokeTemp)
            }
        offset += 30
    }

    private fun getDetailsAboutPokemons(list: List<NamedApiResource>) {
        list.forEach { item ->
            apiClient.getPokemon(item.id)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe {
                    item.hp = it.stats[0].baseStat //hp
                    item.attack = it.stats[1].baseStat //attack
                    item.defence = it.stats[2].baseStat //defence
                    item.imageUrl = it.sprites.frontDefault ?: "" //image
                }
        }
    }

    fun sortPokemons(
        chb_hp: Boolean = false,
        chb_attack: Boolean = false,
        chb_defence: Boolean = false
    ) {
        if (chb_hp && chb_attack && chb_defence) {
            movePokemonOnFirstPosition(
                pokeTemp.maxWithOrNull(
                    compareBy(
                        { it.attack },
                        { it.defence },
                        { it.hp })
                )!!.id
            )
        } else {
            if (chb_hp && chb_attack) {
                movePokemonOnFirstPosition(
                    pokeTemp.maxWithOrNull(
                        compareBy(
                            { it.attack },
                            { it.hp })
                    )!!.id
                )
            }
            if (chb_hp && chb_defence) {
                movePokemonOnFirstPosition(
                    pokeTemp.maxWithOrNull(
                        compareBy(
                            { it.defence },
                            { it.hp })
                    )!!.id
                )
            }
            if (chb_attack && chb_defence) {
                movePokemonOnFirstPosition(
                    pokeTemp.maxWithOrNull(
                        compareBy(
                            { it.attack },
                            { it.defence })
                    )!!.id
                )
            } else {
                if (chb_hp) {
                    movePokemonOnFirstPosition(pokeTemp.maxWithOrNull(compareBy { it.hp })!!.id)
                }
                if (chb_attack) {
                    movePokemonOnFirstPosition(pokeTemp.maxWithOrNull(compareBy { it.attack })!!.id)
                }
                if (chb_defence) {
                    movePokemonOnFirstPosition(pokeTemp.maxWithOrNull(compareBy { it.defence })!!.id)
                }
            }
        }
        if (chb_hp || chb_attack || chb_defence) {
            viewState.updateAdapter(pokeTemp)
            viewState.scrollToStart()
        }
    }

    private fun movePokemonOnFirstPosition(id: Int) {
        val pokemon = pokeTemp.find { it.id == id }
        pokeTemp.remove(pokemon)
        pokeTemp.add(0, pokemon!!)
    }
}