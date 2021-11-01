package com.example.pokebase

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment
import com.arellomobile.mvp.MvpAppCompatDialogFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokebase.models.Pokemon
import com.example.pokebase.presenters.PokemonPresenter
import com.example.pokebase.presenters.view.PokemonView

class DetailInfoFragment : MvpAppCompatDialogFragment(), PokemonView {

    @InjectPresenter
    lateinit var presenter: PokemonPresenter

    //views
    private lateinit var image: ImageView
    private lateinit var pokeName: TextView
    private lateinit var pokeHight: TextView
    private lateinit var pokeWeight: TextView
    private lateinit var pokeType: TextView
    private lateinit var pokeHp: TextView
    private lateinit var pokeAttack: TextView
    private lateinit var pokeDefence: TextView
    private lateinit var pokeDetailsContainer: ConstraintLayout
    private lateinit var pokePbLoad: ProgressBar

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = view.findViewById(R.id.detail_image)
        pokeName = view.findViewById(R.id.pokemon_name)
        pokeHight = view.findViewById(R.id.tv_height_pokemon_value)
        pokeWeight = view.findViewById(R.id.tv_weight_pokemon_value)
        pokeType = view.findViewById(R.id.tv_type_pokemon_value)
        pokeHp = view.findViewById(R.id.tv_hp_pokemon_value)
        pokeAttack = view.findViewById(R.id.tv_attack_pokemon_value)
        pokeDefence = view.findViewById(R.id.tv_defence_pokemon_value)
        pokeDetailsContainer = view.findViewById(R.id.details_container)
        pokePbLoad = view.findViewById(R.id.pb_load)

        presenter.getPokemon(requireArguments().getSerializable("id") as Int)
    }

    companion object {
        fun newInstance(id: Int): DetailInfoFragment {
            return DetailInfoFragment().apply {
                arguments = Bundle().apply {
                    putSerializable("id", id)
                }
            }
        }
    }

    override fun showData(pokemon: Pokemon) {
        Glide.with(this)
            .load(pokemon.sprites.frontDefault)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(image)

        pokeName.text = pokemon.name
        pokeHight.text = pokemon.height.toString()
        pokeWeight.text = pokemon.weight.toString()
        pokeHp.text = pokemon.stats[0].baseStat.toString()
        pokeAttack.text = pokemon.stats[1].baseStat.toString()
        pokeDefence.text = pokemon.stats[2].baseStat.toString()
        pokeType.text = pokemon.types[0].type.name

        pokeDetailsContainer.visibility = View.VISIBLE
        pokePbLoad.visibility = View.GONE
    }
}