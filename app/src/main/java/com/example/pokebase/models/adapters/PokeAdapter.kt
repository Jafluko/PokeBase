package com.example.pokebase.models.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.pokebase.DetailInfoFragment
import com.example.pokebase.R
import com.example.pokebase.models.NamedApiResource
import com.example.pokebase.models.Pokemon
import com.example.pokebase.providers.api.RxPokeApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PokeAdapter(private val click: PokeInterface) : RecyclerView.Adapter<PokeAdapter.PokeHolder>() {

    private val clientApi = RxPokeApiClient()
    var list: List<NamedApiResource> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeHolder {
        return PokeHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_pokemon, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokeHolder, position: Int) {
        clientApi.getPokemon(list[position].id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.newThread())
            .subscribe {
                holder.tvName.text = it.name
                Glide.with(holder.itemView)
                    .load(it.sprites.frontDefault)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(holder.image)

                holder.tvHp.text = it.stats[0].baseStat.toString() //hp
                holder.tvAttack.text = it.stats[1].baseStat.toString() //attack
                holder.tvDefence.text = it.stats[2].baseStat.toString() //defence

                holder.llCardView.visibility = View.VISIBLE
                holder.pbLoad.visibility = View.GONE
            }

        holder.llCardView.setOnClickListener {
            click.clicked(list[position].id)
        }
    }

    override fun getItemCount(): Int = list.size

    class PokeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val image: ImageView = itemView.findViewById(R.id.image_pokemon)
        val tvAttack: TextView = itemView.findViewById(R.id.tv_attack)
        val tvHp: TextView = itemView.findViewById(R.id.tv_hp)
        val tvDefence: TextView = itemView.findViewById(R.id.tv_defence)

        val llCardView: LinearLayout = itemView.findViewById(R.id.ll_item)
        val pbLoad: ProgressBar = itemView.findViewById(R.id.pb_load)
    }
}