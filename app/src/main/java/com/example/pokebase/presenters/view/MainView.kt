package com.example.pokebase.presenters.view

import com.arellomobile.mvp.MvpView
import com.example.pokebase.models.NamedApiResource
import com.example.pokebase.models.Pokemon

interface MainView : MvpView {

    fun updateAdapter(list: List<NamedApiResource>)

    fun showList()
    fun hideList()

    fun showMessage(message: String)
    fun scrollToStart()
}